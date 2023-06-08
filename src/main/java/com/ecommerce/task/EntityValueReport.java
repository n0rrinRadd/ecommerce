package com.ecommerce.task;//package com.ecommerce.search.task;
//
//import com.ecommerce.search.Attribute;
//import com.ecommerce.search.AttributeValue;
//import com.ecommerce.search.CatalogEntry;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class EntityValueReport extends AbstractSearchUtilities {
//
//    private static final String PATH_TO_ENTITY_VALUE_REPORT = "build/entity_value_";
//
//    public static void main(String[] args) {
//        setManagedChannel();
//        validateRequiredArguments();
//        additionalArgumentChecks("jira_ticket");
//
//        List<Map<String, Object>> entityValueReport =
//                populateEntityValueReport(fetchCatalogEntries(searchBuilderWithDetailedInfo()));
//        String pathToFile = String.format(PATH_TO_ENTITY_VALUE_REPORT + "%s.json", JIRA_TICKET
//                .toLowerCase());
//        writeContentsToFile(pathToFile, entityValueReport);
//    }
//
//    private static List<Map<String, Object>> populateEntityValueReport(
//            List<List<CatalogEntry>> catalogEntryList) {
//        List<Map<String, Object>> valueReportList = new ArrayList<>();
//        catalogEntryList.forEach(catalogEntries -> {
//            int catalogEntrySize = catalogEntries.size();
//            if (catalogEntrySize == 0) {
//                return;
//            }
//            Map<String, Object> valueReport = new LinkedHashMap<>();
//            valueReport.put("search_term_" + catalogEntries.get(0).getSearchTerm(),
//                    catalogEntrySize);
//            evaluateCatalogEntries(valueReport, catalogEntries);
//            valueReportList.add(valueReport);
//        });
//        return valueReportList;
//    }
//
//    private static void evaluateCatalogEntries(Map<String, Object> entityValueReport,
//                                               List<CatalogEntry> catalogEntries) {
//        catalogEntries.forEach(catalogEntry -> evaluateAttributes(entityValueReport, catalogEntry));
//    }
//
//    private static void evaluateAttributes(Map<String, Object> entityValueReport,
//                                           CatalogEntry catalogEntry) {
//        catalogEntry.getAttributes().forEach(attribute ->
//                addOrUpdateAttributeDetails(entityValueReport, attribute));
//    }
//
//    private static void addOrUpdateAttributeDetails(Map<String, Object> entityValueReport,
//                                                    Attribute attribute) {
//        addOrUpdateAttribute(entityValueReport, attribute);
//        addOrUpdateAttributeValues(entityValueReport, attribute);
//    }
//
//    private static void addOrUpdateAttribute(Map<String, Object> entityValueReport,
//                                             Attribute attribute) {
//        String attributeNameKey = attribute.getName() + "_attr";
//        addOrUpdate(entityValueReport, attributeNameKey);
//    }
//
//    @SuppressWarnings("unchecked")
//    private static void addOrUpdateAttributeValues(Map<String, Object> entityValueReport,
//                                                   Attribute attribute) {
//        String attributeValueNameKey = attribute.getName() + "_values";
//
//        boolean keyFound = entityValueReport.containsKey(attributeValueNameKey);
//
//        if (!keyFound) {
//            entityValueReport.put(attributeValueNameKey, new LinkedHashMap<>());
//        }
//
//        Map<String, Object> attributeValues = (Map<String, Object>) entityValueReport
//                .get(attributeValueNameKey);
//        attribute.getAttributeValues().forEach(attributeValue ->
//                addOrUpdateAttributeValue(attributeValues, attributeValue));
//    }
//
//    private static void addOrUpdateAttributeValue(Map<String, Object> attributeValues,
//                                                  AttributeValue attributeValue) {
//        String value = attributeValue.getValue();
//        addOrUpdate(attributeValues, value);
//    }
//
//    private static void addOrUpdate(Map<String, Object> attributeValueReport, String valueKey) {
//        if (!attributeValueReport.containsKey(valueKey)) {
//            attributeValueReport.put(valueKey, 1);
//        } else {
//            int existingValueUpdate = (Integer) attributeValueReport.get(valueKey) + 1;
//            attributeValueReport.put(valueKey, existingValueUpdate);
//        }
//    }
//}
