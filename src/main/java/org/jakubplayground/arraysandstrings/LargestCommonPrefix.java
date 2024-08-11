package org.jakubplayground.arraysandstrings;

public class LargestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int firstStringLength = strs[0].length();
        int i = 0;
        char c;
        boolean matches = true;

        while (i < firstStringLength && matches) {
            c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                result.append(c);
                i++;
            }
        }


        return result.toString();
    }
}
