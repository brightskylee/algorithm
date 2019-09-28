package org.test.ht;

import java.util.Arrays;

public class RecoverSortedArray {

    public void recover(int[] arr) {
        int swappedAIndex = 0, swappedBIndex = 0;
        boolean occurred = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] < arr[i]) {
                swappedBIndex = i + 1;
                if (!occurred) {
                    swappedAIndex = i;
                    occurred = true;
                }
            }
        }

        int temp = arr[swappedAIndex];
        arr[swappedAIndex] = arr[swappedBIndex];
        arr[swappedBIndex] = temp;
    }

    public static void main(String[] args) {
        RecoverSortedArray recoverSortedArray = new RecoverSortedArray();
        int[] arr = {1, 2, 3, 4, 5, 7, 6};
        recoverSortedArray.recover(arr);

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
