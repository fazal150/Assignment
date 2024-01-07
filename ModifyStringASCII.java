package com.TapAcademy;

public class ModifyStringASCII {
    public static void main(String[] args) {
        String s = "sHQen}";
        System.out.println("Input String: " + s);

        String transformedString = transformString(s);
        System.out.println("Final Answer: " + transformedString);
    }

    private static String transformString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i++) {
            int asciiValue = (int) chars[i];

            if (asciiValue % 2 == 0 && i < len - 1 && (int) chars[i + 1] != 83) {
                chars[i + 1] += asciiValue % 7;
                if (chars[i + 1] > 127) {
                    chars[i + 1] = 83;
                }
            } else if (asciiValue % 2 != 0 && i > 0 && (int) chars[i - 1] != 83) {
                chars[i - 1] -= asciiValue % 5;
                if (chars[i - 1] < 0) {
                    chars[i - 1] = 83;
                }
            }
        }

        return new String(chars);
    }
}
