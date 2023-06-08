package com.ecommerce.task;

import com.ecommerce.helpers.SearchResultSummary;
import com.ecommerce.helpers.SearchResultSummary.ResultItem;
import com.google.gson.*;

public class SearchResultSummaryParser {

  public static SearchResultSummary parse(String input) {
    Gson gson = new GsonBuilder().create();
    JsonObject searchResult1 = gson.fromJson(input, JsonObject.class);

    String searchTerm = searchResult1.get("searchTerm").getAsString();
    long total = searchResult1.get("total").getAsLong();
    JsonArray items = searchResult1.getAsJsonArray("items");

    SearchResultSummary searchResultSummary = new SearchResultSummary(searchTerm,total);
    for(JsonElement jitem: items){
      searchResultSummary.addItem(conventItem(jitem.getAsJsonObject()));
    }
    return searchResultSummary;
  }

  private static ResultItem conventItem(JsonObject obj) {
    ResultItem item = new SearchResultSummary.ResultItem();
    item.setSku(obj.get("sku").getAsString());
    item.setSkuName(obj.get("skuName").getAsString());
    item.setRank(obj.get("rank").getAsInt());
    return item;
  }
}
