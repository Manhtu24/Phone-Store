package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.exception.AlreadyExistException;
import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.model.Variants;
import com.MTlovec.Phone_Store.repository.VariantRepository;
import com.MTlovec.Phone_Store.request.VariantRequest;
import com.MTlovec.Phone_Store.response.VariantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VariantServiceImpl implements  VariantService{

    private final VariantRepository variantRepository;


    @Override
    public List<VariantResponse> getVariants() {
        List <Variants> variants=variantRepository.findAll();
        List<VariantResponse> response=variants.stream().map(vari->
                new VariantResponse(vari.getId(),
                        vari.getName())).collect(Collectors.toList());
        return  response;
    }

    @Override
    public void createVariant(VariantRequest variantRequest) {
        Variants existVariant=variantRepository.findByName(variantRequest.getName());
        if(existVariant!=null){
            throw new AlreadyExistException("Variant already exist please try again");
        }
        Variants variants=new Variants();
        variants.setName(variantRequest.getName());
        variants.setCreateAt(LocalDateTime.now());
        variantRepository.save(variants);
    }

    @Override
    public void updateVariant(Long variantId, VariantRequest updateVariant) {
        Variants variants=variantRepository.findById(variantId).orElseThrow(()->
                new NotFoundException("Could not found variant with id: "+variantId));
        if(variantRepository.existsByNameAndIdNot(updateVariant.getName(),variantId)){
            throw  new AlreadyExistException("Variant name already exist.Please try again");
        }
        variants.setName(updateVariant.getName());
        variantRepository.save(variants);
    }

    @Override
    public void deleteVariant(Long variantId) {
        Variants variants=variantRepository.findById(variantId).orElseThrow(()->
                new NotFoundException("Could not found variant with id: "+variantId));
        if (variants.getVariantValues().isEmpty()){
            throw  new NotFoundException("Variant can not remove because it refer to other values");
        }
        variantRepository.deleteById(variantId);
    }
}
