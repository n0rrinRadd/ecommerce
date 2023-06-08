package com.ecommerce.helpers;

public class Environment {

    public static String getEnv(){
        return System.getProperty("env").toLowerCase();
    }

    public static String getGrpcTarget(){
        switch (getEnv()) {
            case "prod":
            case "prod-use1-blue":
            case "prod-use2-blu":
            case "prod-green":
                return "dns:///apipool.ecom.ecommerce.com:8000";
            default:
                return "dns:///apipool-qa4.ecom.ecommerce.com:8000";
        }
    }

    public static String getStorefrontBaseUrl() {
        if (System.getProperty("baseUrl").endsWith("/")){
            return System.getProperty("baseUrl").substring(0, System.getProperty("baseUrl").length() - 1);
        }
        return System.getProperty("baseUrl");
    }

    public static String getBaseUrl() {
        if (getStorefrontBaseUrl().contains("www-qat")){
            return "https://www-qat.ecommerce.net";
        }
        else if (getStorefrontBaseUrl().contains("www-stg")){
            return "https://www-stg.ecommerce.net";
        }
        else if (getStorefrontBaseUrl().contains("www.ecommerce") ||getStorefrontBaseUrl().contains("www-use1") || getStorefrontBaseUrl().contains("www-use2")){
            return "https://www.ecommerce.com";
        }
        else{
            return getStorefrontBaseUrl();
        }
    }
}
