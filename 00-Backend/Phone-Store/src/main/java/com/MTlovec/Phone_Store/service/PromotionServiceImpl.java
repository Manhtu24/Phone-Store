package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.model.Promotion;
import com.MTlovec.Phone_Store.repository.PromotionRepository;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService{

    private  final PromotionRepository promotionRepository;


    @Override
    public PaginatedResponse<Promotion> getVouchers(int page, int size,
                                                   LocalDate startedDate,
                                                   LocalDate expiredDate) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Promotion> promotions=promotionRepository.getVouchers(pageable,startedDate,expiredDate);
        PaginatedResponse<Promotion> vouchers= new PaginatedResponse<>(promotions.getContent(),
                                                                        promotions.getTotalPages(),
                                                                        promotions.getNumber()+1);
        return vouchers;
    }
    @Override
    public Promotion getVoucher(Long voucherId) {
        Promotion voucher= promotionRepository.findById(voucherId).orElseThrow(()->
                new NotFoundException("Could not found this voucher"));
        return voucher;
    }

    @Transactional
    @Override
    public Promotion createVoucher(Promotion promotion) {
        if (promotionRepository.existsByName(promotion.getName())){
            throw new RuntimeException("This promotion already exist");
        }
        String startCode="MTS";
        String uuid= UUID.randomUUID().toString().replace("-","");
        String code=startCode+uuid.substring(0,6).toUpperCase();

        promotion.setCode(code);
        promotion.setStatus(true);
        promotion.setCreateAt(LocalDateTime.now());
        return promotionRepository.save(promotion);
    }

    @Transactional
    @Override
    public void updateVoucher(Long id, Promotion newVoucher) {
        Promotion oldVoucher= promotionRepository.findById(id).orElseThrow(()->
                new NotFoundException("Could not found this voucher"));
        if(promotionRepository.existsByNameAndIdNot(newVoucher.getName(),id )){
            throw new RuntimeException("Voucher already exit with name: "+newVoucher.getName());
        }
        oldVoucher.setName(newVoucher.getName());
        oldVoucher.setValue(newVoucher.getValue());
        oldVoucher.setStartTime(newVoucher.getStartTime());
        oldVoucher.setExpiredTime(newVoucher.getExpiredTime());
        oldVoucher.setStatus(newVoucher.isStatus());
        promotionRepository.save(oldVoucher);
    }

    @Transactional
    @Override
    public void deleteVoucher(Long voucherId) {
        Promotion voucher= promotionRepository.findById(voucherId).orElseThrow(()->
                new NotFoundException("Could not found this voucher"));
        promotionRepository.delete(voucher);
    }
}
