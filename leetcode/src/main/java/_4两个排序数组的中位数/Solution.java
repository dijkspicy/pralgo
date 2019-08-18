package _4两个排序数组的中位数;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 *
 * @author dijkspicy
 * @date 2018/4/14
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 == 0 && length2 == 0) {
            return 0;
        }
        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int last = 0;
        int current = 0;
        int half = (length1 + length2) / 2 + 1;
        for (int i1 = 0, i2 = 0; i1 + i2 < half; ) {
            int num1 = i1 < length1 ? nums1[i1] : Integer.MAX_VALUE;
            int num2 = i2 < length2 ? nums2[i2] : Integer.MAX_VALUE;
            if (num1 < num2) {
                i1++;
                current = num1;
            } else {
                i2++;
                current = num2;
            }

            if (i1 + i2 != half) {
                last = current;
            }
        }
        if ((length1 + length2) % 2 == 0) {
            return (last + current) / 2.0;
        } else {
            return current;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 == 0 && length2 == 0) {
            return 0;
        }
        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int half = (length1 + length2) / 2 + 1;
        int[] temp = new int[half];
        for (int i1 = 0, i2 = 0, index = 0; i1 + i2 < half; index++) {
            int num1 = i1 < length1 ? nums1[i1] : Integer.MAX_VALUE;
            int num2 = i2 < length2 ? nums2[i2] : Integer.MAX_VALUE;
            if (num1 < num2) {
                i1++;
                temp[index] = num1;
            } else {
                i2++;
                temp[index] = num2;
            }
        }
        return (length1 + length2) % 2 != 0
                ? temp[half - 1]
                : (temp[half - 1] + temp[half - 2]) / 2.0;
    }
}
