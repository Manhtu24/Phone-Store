package com.MTlovec.Phone_Store.request;

import com.MTlovec.Phone_Store.model.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private Long brandId;
    private List<ImageRequest> descriptionImages;
    private List<ImageRequest> productImages;
    private List<VariantRequest> variants;
    private List<ProductVariantRequest> productVariants;
}
