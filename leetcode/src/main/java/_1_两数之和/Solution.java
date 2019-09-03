package _1_两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 使用hash表示最保险的，题目中出于性能考虑，可以将该hash表替换为数组以提升性能，但是数据大的时候其实不可靠
        Map<Integer, Integer> numsToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            Integer j = numsToIndex.get(sub);
            if (j == null) {
                // 先加入到hash表中的肯定索引更靠前，也就是说j一定是小于i的
                numsToIndex.put(nums[i], i);
                continue;
            }
            return this.createResult(j, i);
        }
        throw new IllegalArgumentException();
    }

    private int[] createResult(int small, int big) {
        return new int[] {small, big};
    }

}
