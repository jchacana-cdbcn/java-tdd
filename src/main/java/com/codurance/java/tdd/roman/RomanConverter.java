package com.codurance.java.tdd.roman;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class RomanConverter {

    private static Map<Integer, String> dictionary = new HashMap<>();
    private static SortedSet<Integer> set;
    static {
        dictionary.put(40, "XL");
        dictionary.put(10, "X");
        dictionary.put(9, "IX");
        dictionary.put(5, "V");
        dictionary.put(4, "IV");
        dictionary.put(1, "I");

        set = new TreeSet<>(dictionary.keySet()).descendingSet();
    }

    public String convert(Integer decimal) {
        String result = "";

        for (Integer key: set) {
            while(decimal >= key) {
                result += dictionary.get(key);
                decimal -= key;
            }
        }
        return result;
    }
}
