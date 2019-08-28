package _3_无重复字符的最长子串;

/**
 * _3无重复字符的最长子串
 *
 * @author t00321127
 * @date 2018/4/3
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("pwwkewsp"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbb"));
        System.out.println(solution.lengthOfLongestSubstring("c"));
        System.out.println(solution.lengthOfLongestSubstring("dvdfd"));
        System.out.println(solution.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
        System.out.println(solution.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "));
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int max = 0;
        int from = 0;
        int to = 1;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            to = i;
            for (int j = to - 1; j >= from; j--) {
                char fromChar = s.charAt(j);
                if (ch == fromChar) {
                    max = Math.max(max, to - from);
                    from = j + 1;
                    break;
                }
            }
        }
        return Math.max(max, to - from + 1);
    }
}
