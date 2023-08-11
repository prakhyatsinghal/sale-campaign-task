package com.sale.campaign.salecampaign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sale.campaign.salecampaign.entity.Campaign;
import com.sale.campaign.salecampaign.service.CampaignService;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService){
        this.campaignService = campaignService;
    }

    @PostMapping
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) {
        Campaign createdCampaign = campaignService.createCampaign(campaign);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampaign);
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        List<Campaign> campaigns = campaignService.getAllCampaigns();

        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/current")
    public ResponseEntity<List<Campaign>> getCurrentCampaigns() {
        List<Campaign> currentCampaigns = campaignService.getCurrentCampaigns();

        return ResponseEntity.ok(currentCampaigns);
    }

    @GetMapping("/past")
    public ResponseEntity<List<Campaign>> getPastCampaigns() {
        List<Campaign> pastCampaigns = campaignService.getPastCampaigns();

        return ResponseEntity.ok(pastCampaigns);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<Campaign>> getUpcomingCampaigns() {
        List<Campaign> upcomingCampaigns = campaignService.getUpcomingCampaigns();

        return ResponseEntity.ok(upcomingCampaigns);
    }
}
