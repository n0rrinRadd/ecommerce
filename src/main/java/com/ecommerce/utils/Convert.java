package com.ecommerce.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Convert {

    public static List<String> stringToList(String words){
        return stringToList(words, true, true, true);
    }

    public static List<String> stringToList(String words, Boolean nonWords, Boolean toLowerCase, Boolean removeEmpty){
        String regex = "";
        if (nonWords) regex = "\\W";
        if (toLowerCase) words = words.toLowerCase();
        List<String> list = new LinkedList<String>(Arrays.asList(words.split(regex)));
        if (removeEmpty) list.removeAll(Collections.singleton(""));
        return list;
    }
}
