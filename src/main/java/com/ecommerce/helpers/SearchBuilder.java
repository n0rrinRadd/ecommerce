package com.ecommerce.helpers;

import site.commerce.catalog.services.CatalogProto;
import site.commerce.catalog.services.CatalogServiceProto;
import org.apache.logging.log4j.core.util.Builder;

import java.util.List;

/**
 * Used to build part of a search request.
 */
public class SearchBuilder {

    private final List<String> searchTerms;
    private final CatalogProto.AccessProfile accessProfile;
    private final CatalogServiceProto.SearchRequest.Inclusion inclusion;
    private final int limit;
    private boolean isFetchingPopularity;

    private SearchBuilder(List<String> searchTerms,
                          CatalogProto.AccessProfile accessProfile,
                          CatalogServiceProto.SearchRequest.Inclusion inclusion,
                          int limit,
                          boolean isFetchingPopularity) {
        this.searchTerms = searchTerms;
        this.accessProfile = accessProfile;
        this.inclusion = inclusion;
        this.limit = limit;
        this.isFetchingPopularity = isFetchingPopularity;
    }

    public List<String> getSearchTerms() {
        return searchTerms;
    }

    public CatalogProto.AccessProfile getAccessProfile() {
        return accessProfile;
    }

    public CatalogServiceProto.SearchRequest.Inclusion getInclusion() {
        return inclusion;
    }

    public int getLimit() {
        return limit;
    }

    public boolean getIfFetchingPopularity() {
        return isFetchingPopularity;
    }

    public void setFetchingPopularity(boolean popularity) {
        this.isFetchingPopularity = popularity;
    }

    public static class Search implements Builder<SearchBuilder> {


        private List<String> searchTerms;
        private CatalogProto.AccessProfile accessProfile;
        private CatalogServiceProto.SearchRequest.Inclusion inclusion;
        private int limit;
        private boolean isFetchingPopularity;

        Search(List<String> searchTerms) {
            this.searchTerms = searchTerms;
        }

        public static Search newBuilder(List<String> searchTerms) {
            return new Search(searchTerms);
        }

        public Search withAccessProfile(AccessProfile accessProfile) {
            switch (accessProfile) {
                case BASIC:
                    this.accessProfile = CatalogProto.AccessProfile.STORE_SUMMARY;
                    break;
                case DETAILED:
                    this.accessProfile = CatalogProto.AccessProfile.STORE_DETAILS;
                    break;
                case ALL:
                    this.accessProfile = CatalogProto.AccessProfile.STORE_ALL;
                    break;
                default:
                    break;

            }
            return this;
        }

        public Search returnProductsOnly() {
            this.inclusion = CatalogServiceProto.SearchRequest.Inclusion.EXCLUDE_PRODUCT;
            return this;
        }

        /**
         * Limit of catalog entries to return. '0' returns the entire list.
         */
        public Search withLimitOf(int limit) {
            this.limit = limit;
            return this;
        }

        public Search isGettingDebugInfo(boolean gettingDebugInfo) {
            this.isFetchingPopularity = gettingDebugInfo;
            return this;
        }

        @Override
        public SearchBuilder build() {
            return new SearchBuilder(searchTerms,
                    accessProfile,
                    inclusion,
                    limit,
                    isFetchingPopularity);
        }
    }
}
