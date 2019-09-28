package org.test.ht;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int[][] distance = new int[s.length()][s.length()];

        if (s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            distance[i][i] = 0;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 1) {
                    distance[j][j + i] = (s.charAt(j) == '(' && s.charAt(j + i) == ')') ? 2 : 0;
                } else {
                    int increment = check(s, distance, j, j + i);
                    distance[j][j + i] = increment > 0 ?
                            distance[j + 1][j + i - 1] + increment :
                            Math.max(distance[j + 1][j + i], distance[j][j + i - 1]);
                }
            }
        }

        return distance[0][s.length() - 1];
    }

    private static int check(String s, int[][] distance, int i, int j) {
        if ((j - i) % 2 == 1 && s.charAt(i) == '(' && s.charAt(j) == ')') {

            if (distance[i + 1][j - 1] == j - i - 1) {
                return 2;
            }

            if (j == i + 3 && s.charAt(i + 1) == ')' && s.charAt(j - 1) == '(') {
                return 4;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String s = "(())(()())";
        System.out.println(longestValidParentheses(s));
    }
}
