package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.exception.AlreadyExistException;
import com.MTlovec.Phone_Store.model.*;
import com.MTlovec.Phone_Store.repository.*;
import com.MTlovec.Phone_Store.request.ImageRequest;
import com.MTlovec.Phone_Store.request.ProductRequest;
import com.MTlovec.Phone_Store.request.ProductVariantRequest;
import com.MTlovec.Phone_Store.request.VariantInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CloudinaryService cloudinaryService;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ProductImageRepository productImageRepository;
    private  final VariantRepository variantRepository;
    private final VariantValueRepository variantValueRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {


        Product product=productRepository.findByName(productRequest.getName());
        if(product!=null){
            throw new AlreadyExistException("Product already exist under name: "+productRequest.getName());
        }
        product=new Product();
        product.setCreateAt(LocalDateTime.now());
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setBrand(brandRepository.findById(productRequest.getBrandId()).orElseThrow());
        product.setCategory(categoryRepository.findById(productRequest.getCategoryId()).orElseThrow());
        productRepository.save(product);

        //product images
        List<ImageRequest> prdImgReq=productRequest.getProductImages();
        List<ProductImage> productImages =new ArrayList<>();
        for (int i=0;i<prdImgReq.size();i++){
            ProductImage productImage=new ProductImage();
            productImage.setImageUrl(prdImgReq.get(i).getImageUrl());
            productImage.setPublicId(prdImgReq.get(i).getPublicId());
            productImage.setCreateAt(LocalDate.now());
            productImages.add(productImage);
        }
        product.setProductImages(productImages);

        //variant_values
        List<VariantInput> varIn=productRequest.getVariants();
        for (int i=0;i<varIn.size();i++){
            Variants variants=variantRepository.findById(varIn.get(i).getVariantId()).orElseThrow();
            List<String> values=varIn.get(i).getValue();
            List<VariantValues> variantValues=new ArrayList<>();
            for (int j=0;j<values.size();j++){
                String val=values.get(i);
                if (variantValueRepository.findByName(val)!=null){
                    continue;
                }
                VariantValues variantValues1=new VariantValues();
                variantValues1.setCreateAt(LocalDateTime.now());
                variantValues.add(variantValues1);
            };
            variants.setVariantValues(variantValues);
            variantRepository.save(variants);
        }

        //product variants
        List<ProductVariantRequest> prodVars=productRequest.getProductVariants();
        List <ProductVariant> productVariants=new ArrayList<>();
        List<String> existSku=new ArrayList<>();
        for (int i=0;i<prodVars.size();i++){
            List<String> skuVal=prodVars.get(i).getVariantCombination();
            List<Long> idList=skuVal.stream().map(val->{
                Long id=variantValueRepository.findIdByName(val);
                return id;
            }).collect(Collectors.toList());
            String sku=idList.stream().map(String ::valueOf)
                    .collect(Collectors.joining("-"));
            if (!existSku.contains(sku)){
                existSku.add(sku);
                ProductVariant productVariant=new ProductVariant();
                productVariant.setStock(prodVars.get(i).getStock());
                productVariant.setImportPrice(prodVars.get(i).getImportPrice());
                productVariant.setSellPrice(prodVars.get(i).getSellPrice());
                productVariant.setSku(sku);

                List<ImageRequest> prodvarImage=prodVars.get(i).getProductImages();
                List<ProductImage> productVariantImages=prodvarImage.stream().map(img->{
                    ProductImage productImage=new ProductImage();
                    productImage.setCreateAt(LocalDate.now());
                    productImage.setMainImage(false);
                    productImage.setImageUrl(img.getImageUrl());
                    productImage.setPublicId(img.getPublicId());
                    return productImage;
                }).collect(Collectors.toList());
                productVariant.setProductVariantImage(productVariantImages);
                productVariants.add(productVariant);
            }
        }
        product.setProductVariants(productVariants);















        //save product

    }

    @Override
    public void updateProduct(Long productId, ProductRequest updateProduct) {

    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
