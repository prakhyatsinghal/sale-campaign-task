package com.sale.campaign.salecampaign.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sale.campaign.salecampaign.entity.Campaign;
import com.sale.campaign.salecampaign.repository.CampaignRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    /**
     * Create a sale campaign
     *
     * @param campaign
     * @return Campaign
     * @throws RuntimeException
     */
    @Override
    public Campaign createCampaign(Campaign campaign) {
        try {
            Objects.requireNonNull(campaign, "Campaign object cannot be null");

            return campaignRepository.save(campaign);
        } catch (Exception e) {
            log.error("An error occurred while creating a campaign", e);

            throw new RuntimeException("Unable to create campaign", e);
        }
    }

    /**
     * Returns information of all the sale campaigns
     *
     * @return list
     * @throws RuntimeException
     */
    @Override
    public List<Campaign> getAllCampaigns() {
        try {
            List<Campaign> campaigns = campaignRepository.findAll();

            if (campaigns.isEmpty()) {
                log.info("No campaigns found");
            } else {
                log.info("Retrieved {} campaigns", campaigns.size());
            }

            return campaigns;
        } catch (Exception e) {
            log.error("An error occurred while retrieving all campaigns", e);

            throw new RuntimeException("Unable to fetch all campaigns", e);
        }
    }

    /**
     * Returns information of all the current sale campaigns
     *
     * @return list
     * @throws RuntimeException
     */
    @Override
    public List<Campaign> getCurrentCampaigns() {
        try {
            LocalDate      currentDate      = LocalDate.now();
            List<Campaign> currentCampaigns = campaignRepository.findByStartDateBeforeAndEndDateAfter(currentDate,
                                                                                                      currentDate);

            log.info("Retrieved {} current campaigns", currentCampaigns.size());

            return currentCampaigns;
        } catch (Exception e) {
            log.error("An error occurred while retrieving current campaigns", e);

            throw new RuntimeException("Unable to fetch current campaigns", e);
        }
    }

    /**
     * Returns information of all the past sale campaigns
     *
     * @return list
     * @throws RuntimeException
     */
    @Override
    public List<Campaign> getPastCampaigns() {
        try {
            LocalDate      currentDate   = LocalDate.now();
            List<Campaign> pastCampaigns = campaignRepository.findByEndDateBefore(currentDate);

            log.info("Retrieved {} past campaigns", pastCampaigns.size());

            return pastCampaigns;
        } catch (Exception e) {
            log.error("An error occurred while retrieving past campaigns", e);

            throw new RuntimeException("Unable to fetch past campaigns", e);
        }
    }

    /**
     * Returns information of all the upcoming sale campaigns
     *
     * @return list
     * @throws RuntimeException
     */
    @Override
    public List<Campaign> getUpcomingCampaigns() {
        try {
            LocalDate      currentDate       = LocalDate.now();
            List<Campaign> upcomingCampaigns = campaignRepository.findByStartDateAfter(currentDate);

            log.info("Retrieved {} upcoming campaigns", upcomingCampaigns.size());

            return upcomingCampaigns;
        } catch (Exception e) {
            log.error("An error occurred while retrieving upcoming campaigns", e);

            throw new RuntimeException("Unable to fetch upcoming campaigns", e);
        }
    }
}
