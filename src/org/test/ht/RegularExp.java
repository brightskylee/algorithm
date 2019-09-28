package org.test.ht;

public class RegularExp {

    public boolean isMatch(String s, String p) {

        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.charAt(p.length()  - 1) == '.') {
            if (s.length() >= 1 && p.length() >= 1) {
                return this.isMatch(s.substring(0,s.length() - 1), p.substring(0, p.length() - 1));
            }
            else {
                return false;
            }
        }

        else if(p.charAt(p.length() - 1) == '*') {
            char last = p.charAt(p.length() - 2);
            boolean match = this.isMatch(s, p.substring(0, p.length() - 2));
            int offset = 0;
            while (!match && s.length() - offset >= 1 && charMatch(s.charAt(s.length() - offset - 1), last)) {
                match = this.isMatch(s.substring(0, s.length() - offset - 1), p.substring(0, p.length() - 2));
                offset++;
            }
            return match;
        }

        else {
            if (s.length() >= 1 && p.length() >= 1) {
                return this.isMatch(s.substring(0,s.length() - 1), p.substring(0, p.length() - 1)) &&
                        s.charAt(s.length() - 1) == p.charAt(p.length() - 1);
            }
            else {
                return false;
            }
        }


    }

    private static boolean charMatch(char c, char toMatch) {
        return toMatch == '.' ? true : toMatch == c;
    }

    public static void main(String args[]) {
        String s = "mississippi";
        String p = ".*.*";

        RegularExp r = new RegularExp();

        System.out.println(r.isMatch(s, p));
    }
}
