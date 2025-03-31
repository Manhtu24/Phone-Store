package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.Promotion;
import com.MTlovec.Phone_Store.response.PaginatedResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PromotionService {

    Promotion getVoucher(Long voucherId);

    PaginatedResponse<Promotion> getVouchers(int page, int size, LocalDate started, LocalDate expired);

    Promotion createVoucher(Promotion promotion);

    void updateVoucher(Long id, Promotion newVoucher);

    void deleteVoucher(Long voucherId);

}
