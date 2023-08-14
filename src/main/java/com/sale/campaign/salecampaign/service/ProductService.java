package com.sale.campaign.salecampaign.service;

import com.sale.campaign.salecampaign.entity.PaginatedProductResponse;
import com.sale.campaign.salecampaign.entity.Product;
import com.sale.campaign.salecampaign.entity.ProductPriceSnapshot;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public List<ProductPriceSnapshot> getProductPricingHistory(String productId);

    public PaginatedProductResponse getPaginatedProducts(int page, int pageSize);
    void adjustPricesForActiveCampaigns(List<Product> products);

    }
