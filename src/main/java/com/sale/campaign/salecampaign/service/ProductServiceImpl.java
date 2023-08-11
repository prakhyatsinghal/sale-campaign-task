package com.sale.campaign.salecampaign.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sale.campaign.salecampaign.entity.Product;
import com.sale.campaign.salecampaign.entity.ProductPriceSnapshot;
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

            return products;
        } catch (Exception e) {
            log.error("An error occurred while retrieving all products", e);

            throw new RuntimeException("Unable to fetch all products", e);
        }
    }

    /**
     * Get a list of paginated products
     *
     * @param page
     * @param pageSize
     * @return Page
     * @throws RuntimeException
     */
    public Page<Product> getPaginatedProducts(int page, int pageSize) {
        try {
            Objects.requireNonNull(page, "Page number cannot be null");
            Objects.requireNonNull(pageSize, "Page size cannot be null");

            if (page <= 0 || pageSize <= 0) {
                throw new IllegalArgumentException("Page number and page size must be positive values");
            }

            Pageable pageable = PageRequest.of(page - 1, pageSize);
            Page<Product> productPage = productRepository.findAll(pageable);

            log.info("Retrieved page {} of products, containing {} items", page, productPage.getNumberOfElements());

            return productPage;
        } catch (IllegalArgumentException e) {
            log.error("Invalid arguments provided for paginated product retrieval", e);
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while retrieving paginated products", e);
            throw new RuntimeException("Unable to fetch paginated products", e);
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


