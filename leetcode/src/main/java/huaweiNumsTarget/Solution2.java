/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package huaweiNumsTarget;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @since 2019-08-22
 */
public class Solution2 {

    /**
     * 需要保证足够大，不能出现hash冲突
     */
    private static final int HASHCODE_SEED = 16383;

    public static void main(String[] args) {
        System.out.println(4096 * 3);
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int[] oriMap = new int[HASHCODE_SEED + 1];
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            int sub = target - num;
            int hashcode = getHashcode(sub);
            if (oriMap[hashcode] != 0) {
                return new int[] {oriMap[hashcode] - 1, i};
            }
            hashcode = getHashcode(num);
            oriMap[hashcode] = i + 1;
        }

        return new int[0];
    }

    private int getHashcode(int sub) {
        return sub & HASHCODE_SEED;
    }
}
