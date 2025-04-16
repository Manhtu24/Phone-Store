package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.request.VariantRequest;
import com.MTlovec.Phone_Store.response.VariantResponse;

import java.util.List;

public interface VariantService {
    void createVariant(VariantRequest variantRequest);

    void updateVariant(Long variantId, VariantRequest updateVariant);

    void deleteVariant(Long variantId);

    List<VariantResponse> getVariants();
}
