package org.test.ht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumNoDuplicate {

    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> maps = new HashMap<>();
        boolean doubleCounted = false;
        for(int i=0;i<nums.length - 1;i++) {
            if (nums[i] * 2 == target && !doubleCounted) {
                ans.add(Arrays.asList(nums[i], nums[i]));
                doubleCounted = true;
            }
            if (maps.containsKey(nums[i]) && !maps.containsKey(maps.get(nums[i]))) {
                ans.add(Arrays.asList(nums[i], maps.get(nums[i])));
            }
            maps.put(target - nums[i], nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        TwoSumNoDuplicate twoSumNoDuplicate = new TwoSumNoDuplicate();
        twoSumNoDuplicate.twoSum(nums, 2);
    }

}
