package leetcode;

import javafx.util.Pair;

/**
 * 二进制反转
 */
public class ReverseBits {
    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        Pair<String, String> p = new Pair<>("","");

        System.out.println(reverseBits(n));
    }
    public static int reverseBits(int n) {
//        int res = 0;
//        for (int i = 0; i < 32; i++) {
//            res |= (n>>>i &1) <<(31-i);
//        }
//        return res;
        int count =0;
        for(int i = 0;i<32;i++){
            if((n>>>i &1)==1){
                count++;
            }
        }
        return count;
    }
}
