package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        int maxL = 0;
        int index = 0;
        for (int i = 0; i < c.length; i++) {
            if (m.containsKey(c[i])) {
                index = Math.max(index, m.get(c[i])+1);
            }
            m.put(c[i], i);
            maxL = Math.max(maxL, i - index+1);
        }
        return maxL;
    }
}
