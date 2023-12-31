package com.sale.campaign.salecampaign;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sale.campaign.salecampaign.entity.Campaign;
import com.sale.campaign.salecampaign.entity.CampaignDiscount;
import com.sale.campaign.salecampaign.entity.Product;
import com.sale.campaign.salecampaign.repository.CampaignRepository;
import com.sale.campaign.salecampaign.repository.ProductRepository;

@Component
public class AppDataInitializer implements CommandLineRunner {
    @Autowired
    private ProductRepository  productRepository;
    @Autowired
    private CampaignRepository campaignRepository;

    private void initializeCampaigns() {

        // Create and save initial campaign data
        Campaign campaign1 = new Campaign();

        campaign1.setStartDate(LocalDate.of(2023, 8, 1));
        campaign1.setEndDate(LocalDate.of(2023, 8, 20));
        campaign1.setTitle("Summer Sale");

        List<CampaignDiscount> campaignDiscounts1 = new ArrayList<>();

        campaignDiscounts1.add(new CampaignDiscount("jeiu8f03", 10));
        campaignDiscounts1.add(new CampaignDiscount("abcd1234", 15));
        campaign1.setCampaignDiscounts(campaignDiscounts1);
        campaignRepository.save(campaign1);

        Campaign campaign2 = new Campaign();

        campaign2.setStartDate(LocalDate.of(2023, 8, 15));
        campaign2.setEndDate(LocalDate.of(2023, 8, 25));
        campaign2.setTitle("Back to School");

        List<CampaignDiscount> campaignDiscounts2 = new ArrayList<>();

        campaignDiscounts2.add(new CampaignDiscount("abcd1234", 12));
        campaign2.setCampaignDiscounts(campaignDiscounts2);
        campaignRepository.save(campaign2);

        Campaign campaign3 = new Campaign();

        campaign3.setStartDate(LocalDate.of(2023, 9, 1));
        campaign3.setEndDate(LocalDate.of(2023, 9, 15));
        campaign3.setTitle("Fall Clearance");

        List<CampaignDiscount> campaignDiscounts3 = new ArrayList<>();

        campaignDiscounts3.add(new CampaignDiscount("efgh5678", 20));
        campaign3.setCampaignDiscounts(campaignDiscounts3);
        campaignRepository.save(campaign3);

        Campaign campaign4 = new Campaign();

        campaign4.setStartDate(LocalDate.of(2023, 10, 2));
        campaign4.setEndDate(LocalDate.of(2023, 11, 1));
        campaign4.setTitle("Diwali Sale");

        List<CampaignDiscount> campaignDiscounts4 = new ArrayList<>();

        campaignDiscounts4.add(new CampaignDiscount("ijkl9012", 25));
        campaignDiscounts4.add(new CampaignDiscount("mnop3456", 30));
        campaign4.setCampaignDiscounts(campaignDiscounts4);
        campaignRepository.save(campaign4);
    }

    private void initializeProducts() {

        // Create and save initial product data
        Product product1 = new Product();

        product1.setId("jeiu8f03");
        product1.setMrp(300);
        product1.setCurrentPrice(250);
        product1.setDiscount(16.66);
        product1.setInventory(2);

        Product product2 = new Product();

        product2.setId("abcd1234");
        product2.setMrp(500);
        product2.setCurrentPrice(400);
        product2.setDiscount(20.0);
        product2.setInventory(5);

        Product product3 = new Product();

        product3.setId("ijkl9012");
        product3.setMrp(800);
        product3.setCurrentPrice(700);
        product3.setDiscount(12.5);
        product3.setInventory(8);

        Product product4 = new Product();

        product4.setId("mnop3456");
        product4.setMrp(1200);
        product4.setCurrentPrice(1000);
        product4.setDiscount(16.66);
        product4.setInventory(15);
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));
    }

    @Override
    public void run(String... args) {
        initializeProducts();
        initializeCampaigns();
    }
}
