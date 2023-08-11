package com.sale.campaign.salecampaign.repository;

import com.sale.campaign.salecampaign.entity.ProductPriceSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPriceSnapshotRepository extends JpaRepository<ProductPriceSnapshot, Long> {
    List<ProductPriceSnapshot> findByProductId(String productId);
}
