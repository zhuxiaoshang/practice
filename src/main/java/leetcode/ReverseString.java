package leetcode;


/**
 * @author 祝
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }
    public static void reverseString(char[] s) {
        int i = 0,j= s.length-1;
        char tmp =' ';
        while (i<=j)
        {
            tmp = s[i];
            s[i]=s[j];
            s[j] = tmp;
            i++;
            j--;
        }

        System.out.println(new String(s));
    }
}
