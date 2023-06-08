package com.ecommerce.helpers;

import io.grpc.Metadata;

public class RpcConstants {

        static final Metadata.Key<String> STORE_ID_HEADER_KEY =
                Metadata.Key.of("Commerce-StoreId", Metadata.ASCII_STRING_MARSHALLER);
        static final Metadata.Key<String> LANGUAGE_ID_HEADER_KEY =
                Metadata.Key.of("Commerce-LanguageId", Metadata.ASCII_STRING_MARSHALLER);
        static final Metadata.Key<String> DEVICEFMT_ID_HEADER_KEY =
                Metadata.Key.of("Commerce-DeviceFormatId", Metadata.ASCII_STRING_MARSHALLER);

}
