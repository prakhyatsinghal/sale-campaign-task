package com.sale.campaign.salecampaign.entity;

import java.util.List;

import lombok.Data;

@Data
public class PaginatedProductResponse {
    private List<Product> products;
    private int           page;
    private int           pageSize;
    private int           totalPages;

    public PaginatedProductResponse() {}

    public PaginatedProductResponse(List<Product> products, int page, int pageSize, int totalPages) {
        this.products   = products;
        this.page       = page;
        this.pageSize   = pageSize;
        this.totalPages = totalPages;
    }
}
