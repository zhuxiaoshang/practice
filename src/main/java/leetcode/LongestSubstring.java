package leetcode;

/**
 * 至少有K个重复字符的最长子串
 */
public class LongestSubstring {

    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        if (k < 2) {
            return chars.length;
        }
        if (s.length() == 0 || s.length() < k) {
            return 0;
        }

        return recusion(chars, 0, chars.length - 1, k);
    }

    public int recusion(char[] chars, int p1, int p2,int k) {
        if (p2 - p1 + 1 < k) {
            return 0;
        }
        int[] counts = new int[26];
        for (int i = p1; i <=p2; i++) {
            counts[chars[i]-'a']++;
        }
        while (p2 - p1 + 1 >=k&&counts[chars[p1]-'a']<k)
            {
                p1++;
            }
        while (p2 - p1 + 1 >= k && counts[chars[p2]-'a'] < k) {
            p2--;
        }
        for (int i = p1; i <=p2 ; i++) {
            if (counts[chars[i]-'a'] < k) {
                return Math.max(recusion(chars,p1,i-1,k),recusion(chars,i+1,p2,k));
            }
        }
        return p2 - p1 + 1;
    }
}
