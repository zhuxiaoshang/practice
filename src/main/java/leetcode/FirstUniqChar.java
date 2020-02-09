package leetcode;

public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("cc"));

    }
    public static int firstUniqChar(String s) {
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(table[s.charAt(i)-'a']==1){
                return i;
            }

        }
        return -1;
    }
}
