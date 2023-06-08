package com.ecommerce.helpers;

import java.util.List;

public class Attribute {

    private String name;
    private List<AttributeValue> attributeValues;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
