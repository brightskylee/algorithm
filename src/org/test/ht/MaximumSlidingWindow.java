package org.test.ht;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSlidingWindow {

    public int[] maximumSlidingWindow(int[] nums, int k){

        int[] results = new int[nums.length - k + 1];
        Deque<Element> queue = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++) {
            if (queue.peekFirst() != null && queue.peekFirst().index < i - k + 1) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] > queue.peekLast().value) {
                queue.pollLast();
            }
            queue.offerLast(new Element(i, nums[i]));
            if (i >= k - 1) {
                results[i - k + 1] = queue.peekFirst().value;
            }
        }

        return results;
    }

    private static class Element {
        int index;
        int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, -2, 2, -3};
        int k = 2;

        MaximumSlidingWindow maximumSlidingWindow = new MaximumSlidingWindow();
        int[] results = maximumSlidingWindow.maximumSlidingWindow(arr, k);
        for (int i=0; i<results.length;i++)
            System.out.println(results[i]);
    }

}
