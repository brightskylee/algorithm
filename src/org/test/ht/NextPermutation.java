package org.test.ht;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int i=nums.length - 2;
        while(i>= 0 && nums[i] >= nums[i+1]) {
            --i;
            continue;
        }

        if (i < 0) {
            reverse(nums, 0);
        }
        else {
            int temp = nums[i];
            int swappedIndex = binarySearch(nums, i+1, nums[i]);
            nums[i] = nums[swappedIndex];
            nums[swappedIndex] = temp;

            reverse(nums, i + 1);
        }

    }

    //Find the index of the smallest number which is greater than target in a decending array
    private int binarySearch(int[] arr, int startIndex, int target) {
        int left = startIndex, right = arr.length - 1;
        while (left <= right) {
            int pivotIndex = (left + right) / 2;
            int pivot = arr[pivotIndex];
            if (target >= pivot) {
                right = pivotIndex - 1;
            }
            else {
                left = pivotIndex + 1;
            }

        }
        return left - 1;
    }

    //Reverse a sorted array
    private void reverse(int[] arr, int startIndex) {
        for(int i=startIndex;i<(arr.length + startIndex)/2;i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length + startIndex - i - 1];
            arr[arr.length + startIndex - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
    }
}
