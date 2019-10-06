package org.test.ht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        return dp(nums, nums.length - 1, target).size();
    }

    private List<List<Integer>> dp(int[] nums, int target) {
        if (k == 0) {
            return target % nums[0] == 0 ? Collections.singletonList(target / nums[0]) : Collections.emptyList();
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            for (List<Integer> list : dp(nums, target-nums[i])) {
                ans.add()
            }
        }

        List<Integer> ans = new ArrayList<>(dp(nums, k - 1, target));
        int i = 1, newTarget;
        while((newTarget = target - nums[k] * i) > 0){
            for (Integer count : dp(nums, k-1, newTarget)) {
                int combination = combination(i+1, count);
                for( int j=0; j<combination;j++) {
                    ans.add(count + i);
                };
            }
            i++;
        }
        if (target % nums[k] == 0) {
            ans.add(target / nums[k]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 1, 3};
        CombinationSum4 combinationSum4 = new CombinationSum4();
        System.out.println(combinationSum4.combinationSum4(nums, 4));
    }

}
