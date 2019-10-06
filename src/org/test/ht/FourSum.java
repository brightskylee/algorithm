package org.test.ht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length - 3;i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            ans.addAll(threeSum(nums, i + 1, target - nums[i], nums[i]));
        }
        return ans;
    }

    //nums is sorted
    private List<List<Integer>> threeSum(int[] nums, int start, int target, int initialNumber) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> previousLeads = new HashSet<>();

        for (int i=start; i<nums.length - 2;i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            int newTarget = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < newTarget) {
                    int previousLeft = nums[left];
                    while(++left < right && nums[left] == previousLeft);
                }
                else if (sum > newTarget) {
                    int previousRight = nums[right];
                    while(--right > left && nums[right] == previousRight);
                }
                else {
                    ans.add(Arrays.asList(initialNumber, nums[i], nums[left], nums[right]));
                    int previousLeft = nums[left];
                    while(++left < right && nums[left] == previousLeft);
                    int previousRight = nums[right];
                    while(--right > left && nums[right] == previousRight);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0,0 ,0};
        FourSum fourSum = new FourSum();
        fourSum.fourSum(nums, 0);
    }
}
