package org.test.ht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.sun.tools.javac.util.ArrayUtils;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumHelper(candidates, candidates.length - 1, target, new LinkedList<>());
    }

    public List<List<Integer>> combinationSumHelper(int[] candidates, int start, int target, LinkedList<Integer> current) {
        List<List<Integer>> ans = new ArrayList<>();
        if (target == 0) {
            LinkedList<Integer> result = new LinkedList<>(current);
            ans.add(result);
            return ans;
        }

        if (target < 0 || start < 0) {
            return ans;
        }

        for(int i=start;i>=0;i--) {
            current.add(candidates[i]);
            List<List<Integer>> combinations = combinationSumHelper(candidates, i, target - candidates[i], current);
            ans.addAll(combinations);
            current.removeLast();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(nums, 35);
    }
}
