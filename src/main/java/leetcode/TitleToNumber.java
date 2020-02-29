package leetcode;

public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
    }

    public static int titleToNumber(String s) {
        int out = 0;
        for (int i = 0; i < s.length(); i++) {
            out += (s.charAt(i) - 'A' + 1) * Math.pow (26,s.length() - 1 - i );
        }
        return out;
    }
}
