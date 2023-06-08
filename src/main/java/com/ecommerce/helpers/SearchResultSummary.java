package com.ecommerce.helpers;

import java.util.ArrayList;
import java.util.List;

public class SearchResultSummary {

    private String searchTerm;
    private long total;
    private List<ResultItem> items = new ArrayList<>();

    public SearchResultSummary(String searchTerm, long total) {
        this.searchTerm = searchTerm;
        this.total = total;
    }

    public void addItem(ResultItem item) {
        if(item != null) {
            this.items.add(item);
        }
    }

    public List<ResultItem> getItems() {
        return items;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public long getTotal() {
        return total;
    }

    public static class ResultItem {

        private String sku;
        private String skuName;
        private int rank;
        private String message;


        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getSkuName() {
            return skuName;
        }

        public void setSkuName(String skuName) {
            this.skuName = skuName;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

    }

}
