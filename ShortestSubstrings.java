package com.TapAcademy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestSubstrings {
    public static void main(String[] args) {
        String s = "abccdbacca";
        int[] xValues = {3, 4, 5, 6, 7, 8};

        for (int x : xValues) {
            List<String> result = findShortestSubstrings(s, x);
            System.out.println("x: " + x + "\tAnswer: " + (result.isEmpty() ? "not-found" : String.join(" ", result)));
        }
    }

    private static List<String> findShortestSubstrings(String s, int x) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (lastIndexMap.containsKey(currentChar)) {
                int startIndex = lastIndexMap.get(currentChar);
                int length = i - startIndex + 1;

                if (length >= x) {
                    String substring = s.substring(startIndex, i + 1);
                    if (result.isEmpty() || length < result.get(0).length()) {
                        result.clear();
                        result.add(substring);
                    } else if (length == result.get(0).length()) {
                        result.add(substring);
                    }
                }
            }

            lastIndexMap.put(currentChar, i);
        }

        return result;
    }
}
