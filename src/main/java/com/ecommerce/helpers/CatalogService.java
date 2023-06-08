package com.ecommerce.helpers;

import com.ecommerce.grpc.DefaultManagedChannel;
import com.ecommerce.helpers.SearchResultSummary.ResultItem;
import com.google.protobuf.Int32Value;
import site.commerce.catalog.services.CatalogProto;
import site.commerce.catalog.services.CatalogServiceGrpc;
import site.commerce.catalog.services.CatalogServiceProto;
import site.commerce.catalog.services.CatalogServiceProto.SearchRequest.Source;
import io.grpc.stub.MetadataUtils;

import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.grpc.meta.CommerceMetaData.getRequiredHeaders;


public class CatalogService {

    public CatalogServiceGrpc.CatalogServiceBlockingStub catalogStub;

    public CatalogService() {
        catalogStub = CatalogServiceGrpc.newBlockingStub(DefaultManagedChannel.getManagedChannel());
        catalogStub = MetadataUtils.attachHeaders(catalogStub, getRequiredHeaders());
    }

    public List<CatalogEntry> getResults(String searchTerm){
        CatalogServiceProto.SearchRequest searchRequest = CatalogServiceProto
            .SearchRequest
            .newBuilder()
            .setSearchTerm(searchTerm)
            .setRecordSetLimit(Int32Value.newBuilder().setValue(36).build())
            .setRecordSetStart(0)
            .setInclusion(CatalogServiceProto.SearchRequest.Inclusion.EXCLUDE_PRODUCT)
            .build();

        CatalogServiceProto.CatalogNavigation navigation = catalogStub.search(searchRequest);
        List<CatalogProto.CatalogEntry> entries = navigation.getCatalogEntryList();

        searchTerm = navigation.getSearchTerm();

        List<CatalogEntry> catalogEntries = new ArrayList<>();

        for(int i=0; i<entries.size(); i++){
            CatalogEntry catalogEntry = new CatalogEntry();
            catalogEntry.setSearchTerm(searchTerm);
            catalogEntry.setSku(entries.get(i).getPartNumber());
            catalogEntry.setRank(i+1);
            catalogEntry.setSkuName(entries.get(i).getName());
            catalogEntries.add(catalogEntry);
        }

        return catalogEntries;
    }

    public SearchResultSummary getResultSummary(String searchTerm) {

        CatalogServiceProto.SearchRequest searchRequest = CatalogServiceProto
            .SearchRequest
            .newBuilder()
            .setSearchTerm(searchTerm)
            .setOriginalSearchTerm(searchTerm)
            .setRecordSetLimit(Int32Value.newBuilder().setValue(36).build())
            .setRecordSetStart(0)
            .setSource(Source.SEARCH_FORM)
            .setAccessProfile(CatalogProto.AccessProfile.STORE_ALL)
            .setGroupResults(true)
            .setCatalogId(1004)
            .setInclusion(CatalogServiceProto.SearchRequest.Inclusion.EXCLUDE_PRODUCT)
            .build();

        CatalogServiceProto.CatalogNavigation navigation = catalogStub.search(searchRequest);
        List<CatalogProto.CatalogEntry> entries = navigation.getCatalogEntryList();

        searchTerm = navigation.getSearchTerm();

        SearchResultSummary searchResultSummary = new SearchResultSummary(searchTerm,navigation.getRecordSetTotal());

        for(int i=0; i<entries.size(); i++){
            ResultItem item = new SearchResultSummary.ResultItem();
            item.setSku(entries.get(i).getPartNumber());
            item.setRank(i+1);
            item.setSkuName(entries.get(i).getName());
            searchResultSummary.addItem(item);
        }

        return searchResultSummary;
    }

//    private List<Future<List<CatalogEntry>>> performParallelSearchExecution()
//            throws InterruptedException {
//        List<String> searchTerms = searchBuilder.getSearchTerms();
//        List<Callable<List<CatalogEntry>>> tasks =
//                searchTerms.stream().<Callable<List<CatalogEntry>>>map(searchTerm -> ()
//                        -> buildCatalogEntryDetails(searchTerm)).collect(Collectors.toList());
//
//        int availableCores = Runtime.getRuntime().availableProcessors();
//
//        System.out.println("NUMBER OF THREADS EXECUTING: " + String.valueOf(availableCores));
//
//        ExecutorService executorService =
//                Executors.newFixedThreadPool(availableCores);
//
//        List<Future<List<CatalogEntry>>> futures;
//
//        try {
//            futures = executorService.invokeAll(tasks);
//        } finally {
//            executorService.shutdown();
//        }
//        return futures;
//    }

}