/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package huaweiNums;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数
 *
 * @since 2019-08-22
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int indexOfNonzero = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                indexOfNonzero = indexOfNonzero(nums, Math.max(indexOfNonzero, i));
                if (i != indexOfNonzero) {
                    swap(nums, i, indexOfNonzero);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int indexOfNonzero(int[] nums, int i) {
        for (int j = i; j < nums.length; j++) {
            if (nums[j] != 0) {
                return j;
            }
        }
        return i;
    }
}
