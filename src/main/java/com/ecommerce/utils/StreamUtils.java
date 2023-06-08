package com.ecommerce.utils;

import com.ecommerce.exception.ElementNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Helper methods for performing various tasks using Streams.
 */
public class StreamUtils {

    /**
     * Return the first possible element from the expression and have the caller decide what to do with
     * the result.
     */
    public static <T> Optional<T> filterAndFindFirst(List<T> elements, Predicate<T> expression) {
        return elements.stream().filter(expression).findFirst();
    }

    /**
     * Same as filterAndFindFirst(), but will throw an exception if the element is not found.
     */
    public static <T> T filterAndFind(List<T> elements, Predicate<T> expression) {
        return filterAndFindFirst(elements, expression)
                .orElseThrow(() -> new ElementNotFoundException("Element not found in collection"));
    }

    /**
     * Converts an object to another.
     */
    public static <T, R> List<R> mapToObjectList(List<T> objectListToMap, Function<T, R> function) {
        return objectListToMap.stream().map(function).collect(Collectors.toList());
    }

    /**
     * Converts an object to another.
     */
    public static <T, R> R mapToObject(T objectToMap, Function<T, R> function) {
        return function.apply(objectToMap);
    }
}
