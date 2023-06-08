package com.ecommerce.helpers;

import io.grpc.Metadata;

public class CommerceMetaData {

    private static final Long storeId = 10L;
    private static final Long languageId = -1L;
    private static final Long deviceFormatId = -1L;

    /**
     * Required gRPC headers.
     */
    public static Metadata getRequiredHeaders() {
        Metadata headers = new Metadata();
        headers.put(RpcConstants.STORE_ID_HEADER_KEY, String.valueOf(storeId));
        headers.put(RpcConstants.LANGUAGE_ID_HEADER_KEY, String.valueOf(languageId));
        headers.put(RpcConstants.DEVICEFMT_ID_HEADER_KEY, String.valueOf(deviceFormatId));
        return headers;
    }
}
