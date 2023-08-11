package com.sale.campaign.salecampaign.repository;

import com.sale.campaign.salecampaign.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByEndDateBefore(LocalDate currentDate);

    List<Campaign> findByStartDateBeforeAndEndDateAfter(LocalDate currentDate1, LocalDate currentDate2);

    List<Campaign> findByStartDateAfter(LocalDate currentDate);
}

