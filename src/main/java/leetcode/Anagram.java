package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效的字母异位词，LeetCode242
 */
public class Anagram {
    public static void main(String[] args) {
        String s = "ac", t = "bb";
        System.out.println(isAnagram(s,t));
    }
    //1.暴力法
    public static boolean isAnagram1(String s, String t) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            list.add(t.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                return false;
            }
            list.remove((Character) s.charAt(i));
        }
        return list.isEmpty();
    }
    //2.
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            table[s.charAt(i)-'a']++;
            table[t.charAt(i)-'a']--;

        }
        for (int count : table) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
