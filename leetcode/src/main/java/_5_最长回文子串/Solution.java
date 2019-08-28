package _5_最长回文子串;

/**
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * <p>
 * 示例：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author dijkspicy
 * @date 2018/4/14
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[] range = new int[]{0, 1};
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            i = this.helper(c, i, range);
        }
        return s.substring(range[0], range[1]);
    }

    private int helper(char[] original, int index, int[] range) {
        int low = index;
        int hi = index;
        // 对于相同的字符直接pass
        while (hi < original.length - 1 && original[hi] == original[hi + 1]) {
            hi++;
        }
        int reset = hi;
        // 向两边辐射进行比较
        while (low - 1 >= 0 && hi + 1 < original.length && original[hi + 1] == original[low - 1]) {
            hi++;
            low--;
        }
        if (hi - low + 1 > range[1] - range[0]) {
            range[0] = low;
            range[1] = hi + 1;
        }
        return reset;
    }

    public String longestPalindromeOfManacher(String str) {
        char[] t = this.preprocess(str);
        int[] p = new int[t.length];
        int mid = 0, right = 0;
        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * mid - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                mid = i;
                right = i + p[i];
            }
        }

        int length = 0;
        int center = 0;
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return str.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    private char[] preprocess(String s) {
        char[] t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
        return t;
    }
}
