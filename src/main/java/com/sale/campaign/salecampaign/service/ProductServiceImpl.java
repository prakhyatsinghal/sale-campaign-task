package com.sale.campaign.salecampaign.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sale.campaign.salecampaign.entity.*;
import com.sale.campaign.salecampaign.repository.ProductPriceSnapshotRepository;
import com.sale.campaign.salecampaign.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository              productRepository;
    @Autowired
    private ProductPriceSnapshotRepository productPriceSnapshotRepository;
    @Autowired
    private CampaignService                campaignService;

    /**
     * It Adjusts the product price according to the cuurent sale(if any)
     *
     * @param products
     * @return list
     * @throws RuntimeException
     */
    @Override
    public void adjustPricesForActiveCampaigns(List<Product> products) {
        try {
            Objects.requireNonNull(products, "Products list cannot be null");

            // Retrieve active campaigns
            List<Campaign> activeCampaigns = campaignService.getCurrentCampaigns();

            // Iterate through products and adjust prices based on campaigns
            for (Product product : products) {
                double adjustedPrice = calculateAdjustedPrice(product, activeCampaigns);

                product.setCurrentPrice(adjustedPrice);
                productRepository.save(product);
            }

            log.info("Adjusted prices for {} products based on active campaigns", products.size());
        } catch (Exception e) {
            log.error("An error occurred while adjusting prices for active campaigns", e);

            throw new RuntimeException("Unable to adjust prices for active campaigns", e);
        }
    }

    /**
     * Calculates the adjusted price for a product based on active campaigns.
     *
     * @param product
     * @param campaigns
     * @return The adjusted price of the product.
     */
    private double calculateAdjustedPrice(Product product, List<Campaign> campaigns) {
        double adjustedPrice = product.getCurrentPrice();

        for (Campaign campaign : campaigns) {
            for (CampaignDiscount discount : campaign.getCampaignDiscounts()) {
                if (discount.getProductId().equals(product.getId())) {
                    double discountPercentage = discount.getDiscount() / 100.0;

                    adjustedPrice = adjustedPrice - (adjustedPrice * discountPercentage);
                }
            }
        }

        return adjustedPrice;
    }

    /**
     * Get a list of paginated products
     *
     * @param page
     * @param pageSize
     * @return Page
     * @throws RuntimeException
     */
    @Override
    public PaginatedProductResponse getPaginatedProducts(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Product> productPage = productRepository.findAll(pageable);
        List<Product> products = productPage.getContent();
        int totalPages = productPage.getTotalPages();

        adjustPricesForActiveCampaigns(products);

        return new PaginatedProductResponse(products, page, pageSize, totalPages);
    }


    /**
     * Fetches information of all the products
     *
     * @return list
     * @throws RuntimeException
     */
    @Override
    public List<Product> getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();

            if (products.isEmpty()) {
                log.info("No products found");
            } else {
                log.info("Retrieved {} products", products.size());
            }

            // Adjust prices for active campaigns
            adjustPricesForActiveCampaigns(products);

            return products;
        } catch (Exception e) {
            log.error("An error occurred while retrieving all products", e);

            throw new RuntimeException("Unable to fetch all products", e);
        }
    }

    /**
     * Get pricing history for a particular product
     *
     * @param productId
     * @return list
     * @throws RuntimeException
     */
    @Override
    public List<ProductPriceSnapshot> getProductPricingHistory(String productId) {
        try {
            Objects.requireNonNull(productId, "Product ID cannot be null");

            List<ProductPriceSnapshot> pricingHistory = productPriceSnapshotRepository.findByProductId(productId);

            log.info("Retrieved {} pricing history entries for product {}", pricingHistory.size(), productId);

            return pricingHistory;
        } catch (Exception e) {
            log.error("An error occurred while retrieving product pricing history", e);

            throw new RuntimeException("Unable to fetch product pricing history", e);
        }
    }
}
