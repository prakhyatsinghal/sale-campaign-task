package com.sale.campaign.salecampaign.controller;

import java.util.List;

import com.sale.campaign.salecampaign.entity.PaginatedProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sale.campaign.salecampaign.entity.Product;
import com.sale.campaign.salecampaign.entity.ProductPriceSnapshot;
import com.sale.campaign.salecampaign.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<PaginatedProductResponse> getPaginatedProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        PaginatedProductResponse response = productService.getPaginatedProducts(page, pageSize);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pricing-history/{productId}")
    public ResponseEntity<List<ProductPriceSnapshot>> getProductPricingHistory(@PathVariable String productId) {
        List<ProductPriceSnapshot> pricingHistory = productService.getProductPricingHistory(productId);

        return ResponseEntity.ok(pricingHistory);
    }
}

