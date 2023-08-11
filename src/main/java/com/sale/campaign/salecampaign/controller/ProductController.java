package com.sale.campaign.salecampaign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<Product>> getPaginatedProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {

        Page<Product> productsPage = productService.getPaginatedProducts(page, pageSize);

        return ResponseEntity.ok(productsPage);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/pricing-history/{productId}")
    public ResponseEntity<List<ProductPriceSnapshot>> getProductPricingHistory(@PathVariable String productId) {
        List<ProductPriceSnapshot> pricingHistory = productService.getProductPricingHistory(productId);

        return ResponseEntity.ok(pricingHistory);
    }
}

