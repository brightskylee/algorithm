package org.test.ht;

public class LongestCommonSubstring {

    public static String longestCommonSubstring(String s1, String s2) {
        String result;
        if (s1.length() == 0 || s2.length() == 0) {
            return "";
        }

        String noS1Last = longestCommonSubstring(s1.substring(0, s1.length() - 1), s2);
        String noS2Last = longestCommonSubstring(s1, s2.substring(0, s2.length() - 1));

        if (noS1Last.length() > noS2Last.length()) {
            result = noS1Last;
        }
        else {
            result = noS2Last;
        }

        String lcsContainingLast = "";
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(s1.length() - i -1) == s2.charAt(s2.length() - i - 1)) {
                lcsContainingLast = s1.charAt(s1.length() - i -1) + lcsContainingLast;
            }
            else {
                break;
            }
        }

        if (result.length() < lcsContainingLast.length()) {
            result = lcsContainingLast;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(longestCommonSubstring("skabcldde", "iabcsfeddg"));
    }
}
