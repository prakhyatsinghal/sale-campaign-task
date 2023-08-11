package com.sale.campaign.salecampaign.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "campaign_id")
    private List<CampaignDiscount> campaignDiscounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CampaignDiscount> getCampaignDiscounts() {
        return campaignDiscounts;
    }

    public void setCampaignDiscounts(List<CampaignDiscount> campaignDiscounts) {
        this.campaignDiscounts = campaignDiscounts;
    }
}

