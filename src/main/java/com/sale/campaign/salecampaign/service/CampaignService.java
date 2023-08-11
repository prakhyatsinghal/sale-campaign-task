package com.sale.campaign.salecampaign.service;

import com.sale.campaign.salecampaign.entity.Campaign;

import java.util.List;

public interface CampaignService {

     Campaign createCampaign(Campaign campaign);

     List<Campaign> getAllCampaigns();

     List<Campaign> getPastCampaigns();

     List<Campaign> getCurrentCampaigns();

     List<Campaign> getUpcomingCampaigns();
}
