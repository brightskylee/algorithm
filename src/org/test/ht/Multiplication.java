package org.test.ht;

public class Multiplication {

    public String multiply(String num1, String num2) {
        char[] numchar1 = num1.toCharArray();
        char[] numchar2 = num2.toCharArray();

        int length1 = num1.length();
        int length2 = num2.length();

        int[] bitMap = new int[length1 + length2];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                int value1 = numchar1[length1 - 1 - i] - '0';
                int value2 = numchar2[length2 - 1 - j] - '0';
                bitMap[i+j] += value1 * value2;
            }
        }

        for (int i=0;i<bitMap.length - 1;i++) {
            int temp = bitMap[i];
            bitMap[i] %= 10;
            bitMap[i+1] += temp/10;
        }

        String result = "";
        boolean leadingZero = true;
        for (int i = bitMap.length - 1; i >= 0; i--) {
            if (leadingZero && bitMap[i] == 0) {
                continue;
            }
            result += bitMap[i];
            leadingZero = false;
        }

        if (result == "") {
            result = "0";
        }
        return result;
    }

    public static void main(String args[]) {
        Multiplication multiplication = new Multiplication();
        System.out.println(multiplication.multiply("123", "456"));
    }
}
