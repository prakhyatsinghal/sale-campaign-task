package com.sale.campaign.salecampaign.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProductPriceSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private double price;
    private LocalDateTime snapshotDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getSnapshotDateTime() {
        return snapshotDateTime;
    }

    public void setSnapshotDateTime(LocalDateTime snapshotDateTime) {
        this.snapshotDateTime = snapshotDateTime;
    }
}

