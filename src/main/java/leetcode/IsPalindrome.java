package leetcode;

public class IsPalindrome {
    public static void main(String[] args) {

        System.out.println(isPalindrome("`l;`` 1o1 ??;l`"));
    }
    public static boolean isPalindrome(String s) {
        char[] chars = new char[s.length()];
        int c = 0;
        for (int i = 0; i <s.length() ; i++) {
            char character = s.charAt(i);
            if(character>='A'&&character<='Z')
            {
                chars[c++] = (char) (character+32);
            }else if((character>='a'&&character<='z')||(character>='0'&&character<='9')){
                chars[c++] = character;
            }else {
                continue;
            }
        }
        int start = 0;
        int end = c-1;
        while (start <= end) {

            if(chars[start]==chars[end]){
                start++;
                end--;
            }
            else {
                return false;
            }

        }
    return true;
    }

}
