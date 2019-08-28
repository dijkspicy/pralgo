/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package _15_三数之和;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return Collections.emptyList();
        }

        // 双指针，固定第一个数，两边向中间靠拢。值得注意的是，需要去重
        List<List<Integer>> result = new LinkedList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] > 0) {
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                if (nums[third] < 0) {
                    break;
                }

                int value = nums[first] + nums[second] + nums[third];
                if (value == 0) {
                    result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    while (second < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    second++;
                    third--;
                } else if (value > 0) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return result;
    }
}
