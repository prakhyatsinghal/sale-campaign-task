package com.sale.campaign.salecampaign.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    private String id;
    private double mrp;
    private double currentPrice;
    private double discount;
    private int inventory;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CampaignDiscount> campaignDiscounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
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

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public List<CampaignDiscount> getCampaignDiscounts() {
        return campaignDiscounts;
    }

    public void setCampaignDiscounts(List<CampaignDiscount> campaignDiscounts) {
        this.campaignDiscounts = campaignDiscounts;
    }

}

