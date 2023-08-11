package com.sale.campaign.salecampaign.service;

import com.sale.campaign.salecampaign.entity.Product;
import com.sale.campaign.salecampaign.entity.ProductPriceSnapshot;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public List<ProductPriceSnapshot> getProductPricingHistory(String productId);

    public Page<Product> getPaginatedProducts(int page, int pageSize);

    }
