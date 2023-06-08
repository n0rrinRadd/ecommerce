package com.ecommerce.helpers;

import site.commerce.catalog.services.CatalogProto;
import site.commerce.catalog.services.CatalogServiceProto;
import org.apache.logging.log4j.core.util.Builder;

import java.util.List;

/**
 * Configure searches based on what information is to be returned as part of
 * the response.
 */
public class SearchConfigurationBuilder {

    private final List<String> searchTerms;
    private final CatalogProto.AccessProfile accessProfile;
    private final CatalogServiceProto.SearchRequest.Inclusion inclusion;
    private final int limit;
    private final boolean debugInfo;

    private int recordSetStart = 0;

    private SearchConfigurationBuilder(List<String> searchTerms,
                                       CatalogProto.AccessProfile accessProfile,
                                       CatalogServiceProto.SearchRequest.Inclusion inclusion,
                                       int limit,
                                       boolean debugInfo) {
        this.searchTerms = searchTerms;
        this.accessProfile = accessProfile;
        this.inclusion = inclusion;
        this.limit = limit;
        this.debugInfo = debugInfo;
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

    public int getRecordSetStart() {
        return recordSetStart;
    }

    public void setRecordSetStart(int recordSetStart) {
        this.recordSetStart = recordSetStart;
    }

    public boolean getDebugInfo() {
        return debugInfo;
    }

    public static class SearchConfiguration implements Builder<SearchConfigurationBuilder> {

        private List<String> searchTerms;
        private CatalogProto.AccessProfile accessProfile;
        private CatalogServiceProto.SearchRequest.Inclusion inclusion;
        private int limit;
        private boolean debugInfo = false;

        SearchConfiguration(List<String> searchTerms) {
            this.searchTerms = searchTerms;
        }

        public static SearchConfiguration forSearchTerms(List<String> searchTerms) {
            return new SearchConfiguration(searchTerms);
        }

        public SearchConfiguration withAccessProfile(AccessProfile accessProfile) {
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

        /**
         * Only products will return in the response.
         */
        public SearchConfiguration returnProductsOnly() {
            this.inclusion = CatalogServiceProto.SearchRequest.Inclusion.EXCLUDE_PRODUCT;
            return this;
        }

        /**
         * Limit the number catalog entries to return. '0' returns the entire list.
         */
        public SearchConfiguration withLimitOf(int limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Debug info contains hidden metadata for each catalog. (Internal use only)
         */
        public SearchConfiguration retrieveDebugInfo() {
            this.debugInfo = true;
            return this;
        }

        @Override
        public SearchConfigurationBuilder build() {
            return new SearchConfigurationBuilder(searchTerms,
                    accessProfile,
                    inclusion,
                    limit,
                    debugInfo);
        }
    }
}
