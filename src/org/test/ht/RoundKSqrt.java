package org.test.ht;

import java.math.BigDecimal;

public class RoundKSqrt {

    public String roundKSqrt(double x, int k) {
        String current = "";
        for (int i = 0; i <= k; i++) {
            int low, high;
            if (i == 0) {
                low = 0;
                high = (int) x;
            } else {
                low = 0;
                high = 9;
            }

            String tmp;
            while (low < high - 1) {
                int middle = low + (high - low) / 2;
                tmp = current + middle;
                if (Double.valueOf(tmp) * Double.valueOf(tmp) < x) {
                    low = middle;
                }
                else if (Double.valueOf(tmp) * Double.valueOf(tmp) == x){
                    return tmp;
                }
                else {
                    high = middle;
                }
            }

            tmp = current + high;
            if (Double.valueOf(tmp) * Double.valueOf(tmp) == x) {
                return tmp;
            }

            current += low;
            if (i==0) {
                current += ".";
            }
        }
        return current;
    }

    public static void main(String args[]) {
        RoundKSqrt roundKSqrt = new RoundKSqrt();
        System.out.println(roundKSqrt.roundKSqrt(0.0081, 4));
    }

}
