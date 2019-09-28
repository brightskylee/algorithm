package org.test.ht;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBookLetterCombo {

    public List<String> letterCombinations(String digits) {

        final char[][] keypadMap = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        char[] digitChars = digits.toCharArray();

        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> results = new ArrayList<>();
        for (Character c : keypadMap[Integer.parseInt(Character.toString(digitChars[0]))]) {
            results.add(c.toString());
        }

        for(int i=1;i<digits.length();i++) {
            List<String> newResults = new ArrayList<>();
            for(String r : results) {
                for (Character character : keypadMap[Integer.parseInt(Character.toString(digitChars[i]))])
                    newResults.add(r + character);
            }
            results = newResults;
        }
        return results;
    }


    public static void main(String[] args) {
        PhoneBookLetterCombo phoneBookLetterCombo = new PhoneBookLetterCombo();
        System.out.println(phoneBookLetterCombo.letterCombinations("7"));
    }
}
