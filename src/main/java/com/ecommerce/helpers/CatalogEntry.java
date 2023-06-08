package com.ecommerce.helpers;

import site.commerce.catalog.services.CatalogProto;

import java.util.ArrayList;
import java.util.List;

public class CatalogEntry {

    private String searchTerm;
    private String sku;
    private String skuName;
    private int rank;
    private String message;

    static CatalogEntry retrieveCatalogDetails(CatalogProto.AccessProfile accessProfile,
                                               CatalogProto.CatalogEntry catalogEntryProto) {
        return accessProfile.equals(CatalogProto.AccessProfile.STORE_SUMMARY)
                ? retrieveBasicDetails(catalogEntryProto)
                : retrieveAdvancedDetails(catalogEntryProto);
    }

    private static CatalogEntry retrieveBasicDetails(CatalogProto.CatalogEntry catalogEntryProto) {
        CatalogEntry catalogEntry = new CatalogEntry();
        catalogEntry.setSku(catalogEntryProto.getPartNumber());
        catalogEntry.setSkuName(catalogEntryProto.getName());
        return catalogEntry;
    }

    private static CatalogEntry retrieveAdvancedDetails(CatalogProto.CatalogEntry catalogEntry) {
        CatalogEntry detailedCatalogEntry = retrieveBasicDetails(catalogEntry);

        List<CatalogProto.Attribute> attributesProto = catalogEntry.getAttributeList();

        List<Attribute> attributes = new ArrayList<>();

        attributesProto.forEach(attributeProto -> {
            Attribute attribute = new Attribute();
            attribute.setName(attributeProto.getIdentifier());
            List<CatalogProto.AttributeValue> values = attributeProto.getValueList();
            List<AttributeValue> attributeValues = new ArrayList<>();
            values.forEach(value -> {
                AttributeValue attributeValue = new AttributeValue();
                attributeValue.setValue(value.getValue());
                attributeValues.add(attributeValue);
            });
            attribute.setAttributeValues(attributeValues);
            attributes.add(attribute);
        });

        return detailedCatalogEntry;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
