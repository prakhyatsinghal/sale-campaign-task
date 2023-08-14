package com.sale.campaign.salecampaign.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;

@Entity
public class Product {
    @Id
    private String                 id;
    private double                 mrp;
    private double                 currentPrice;
    private double                 standardPrice;
    private double                 discount;
    private int                    inventory;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CampaignDiscount> campaignDiscounts;

    public List<CampaignDiscount> getCampaignDiscounts() {
        return campaignDiscounts;
    }

    public void setCampaignDiscounts(List<CampaignDiscount> campaignDiscounts) {
        this.campaignDiscounts = campaignDiscounts;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
    }
}

