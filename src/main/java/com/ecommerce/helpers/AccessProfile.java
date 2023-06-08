package com.ecommerce.helpers;

/**
 * What information to be included in the response for a catalog entry.
 */
public enum AccessProfile {

    /**
     * Summary data only, thumbnail only, important keywords only, suitable for lists.
     */
    BASIC,
    /**
     * Adds prices, long descriptions, full-size image, attribute list.
     */
    DETAILED,
    /**
     * Everything that the catalog includes.
     */
    ALL
}
