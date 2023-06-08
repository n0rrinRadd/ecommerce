package com.ecommerce.helpers;

import com.ecommerce.helpers.SearchResultSummary.ResultItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultComparator {

    public static Result compare(SearchResultSummary summary1, SearchResultSummary summary2) {
        Result result = new Result();
        result.searchTerm = summary1.getSearchTerm();
        result.setNetTotal(summary2.getTotal() - summary1.getTotal());

        List<String> unprocessed = summary1.getItems().stream().map(x -> x.getSku()).collect(Collectors.toList());

        for(ResultItem item2 : summary2.getItems()){
            boolean processed = false;
            for(ResultItem item1 : summary1.getItems()) {
                if(item2.getSku().equals(item1.getSku())) {
                    if( item2.getRank() != item1.getRank()) {
                        result.changed.add(item2.getSku());
                    }
                    unprocessed.remove(item2.getSku());
                    processed = true;
                    break;
                }
            }

            if(!processed) {
                unprocessed.remove(item2.getSku());
                result.added.add(item2.getSku());
            }
        }
        result.removed.addAll(unprocessed);

        return result;
    }

    public static class Result {

        private String searchTerm;

        private List<String> added = new ArrayList<>();
        private List<String> removed = new ArrayList<>();
        private List<String> changed = new ArrayList<>();
        private long netTotal;

        public String getSearchTerm() {
            return searchTerm;
        }

        public void setSearchTerm(String searchTerm) {
            this.searchTerm = searchTerm;
        }


        public int getAddedCnt() {
            return added.size();
        }

        public int getRemovedCnt() {
            return removed.size();
        }

        public int getChangedCnt() {
            return changed.size();
        }

        public List<String> getAdded() {
            return added;
        }

        public List<String> getRemoved() {
            return removed;
        }

        public List<String> getChanged() {
            return changed;
        }

        public long getNetTotal() {
            return netTotal;
        }

        public void setNetTotal(long netTotal) {
            this.netTotal = netTotal;
        }
    }

}
