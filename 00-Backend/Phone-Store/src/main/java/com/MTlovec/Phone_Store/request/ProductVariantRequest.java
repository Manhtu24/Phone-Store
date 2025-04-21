package com.MTlovec.Phone_Store.request;

import com.MTlovec.Phone_Store.model.ProductImage;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantRequest {

    private List<String> variantCombination;

    private BigDecimal importPrice;

    private BigDecimal sellPrice;

    private int stock;

    private List<ImageRequest> productImages;
}
