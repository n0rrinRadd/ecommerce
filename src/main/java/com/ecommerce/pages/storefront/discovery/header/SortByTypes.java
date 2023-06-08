package com.ecommerce.pages.storefront.discovery.header;

public enum SortByTypes {

    RELEVANCE("Relevance"),
    NEWEST("Newest"),
    PRICELOWTOHIGH("Price: Low to High"),
    PRICEHIGHTOLOW("Price: High to Low"),
    AVGCUSTOMERREVIEWS("Avg. Customer Reviews"),
    MOSTREVIEWS("");

    private String sortBy;

    SortByTypes (String sortBy){ this.sortBy = sortBy;}

    public String getSortBy() {return this.sortBy;}
}
