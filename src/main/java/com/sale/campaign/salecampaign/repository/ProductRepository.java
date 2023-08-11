package com.sale.campaign.salecampaign.repository;

import com.sale.campaign.salecampaign.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Find all products
    List<Product> findAll();

    // Find a product by productId
    Optional<Product> findById(String id);
}


