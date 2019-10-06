package org.test.ht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> previousLeads = new HashSet<>();
        for(int i=0; i<nums.length - 2;i++) {
            if (previousLeads.contains(nums[i])) {
                continue;
            }
            int newTarget = target - nums[i];
            Map<Integer, Integer> maps = new HashMap<>();
            boolean duplicateCounted = false;
            for (int j=i + 1; j<nums.length; j++) {
                if (previousLeads.contains(nums[j])) {
                    continue;
                }

                if (maps.containsKey(nums[j])) {
                    if (nums[j] * 2 == newTarget && !duplicateCounted) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[j]));
                        duplicateCounted = true;
                    }

                    if (!maps.containsKey(maps.get(nums[j]))) {
                        ans.add(Arrays.asList(nums[i], nums[j], newTarget - nums[j]));
                    }
                }

                maps.put(newTarget - nums[j], nums[j]);
            }
            previousLeads.add(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(nums, 0);
     }
}
