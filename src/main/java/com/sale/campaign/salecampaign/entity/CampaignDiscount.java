package com.sale.campaign.salecampaign.entity;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
public class CampaignDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String productId;
    private double discount;

    public CampaignDiscount() {}

    public CampaignDiscount(String productId, double discount) {
        this.productId = productId;
        this.discount  = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

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
}
