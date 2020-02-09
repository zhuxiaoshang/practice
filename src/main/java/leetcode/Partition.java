package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 分隔回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
 */
public class Partition {
    public static void main(String[] args) {
//        System.out.println(isPalindrome2("ssfsfsf"));
        Deque<String> deque = new ArrayDeque<>();
        List<List<String>> result = new ArrayList<>();
        String s = "aaab";
        backTracing(s,0,isPalindrome2(s),deque,result);
        System.out.println(result);
    }

    public static void backTracing(String s, int start, boolean[][] dp, Deque path, List<List<String>> resultSet){
        if(start == s.length())
        {//到达字符串末尾
            resultSet.add(new ArrayList<>(path));
            return;
        }
        //DFS+回溯
        for (int i = start; i <s.length() ; i++) {
            if(!dp[start][i]){
                continue;
            }
            path.addLast(s.substring(start,i+1));//substring 前闭后开
            backTracing(s,i+1,dp,path,resultSet);
            path.removeLast();
        }
    }

    public  static boolean isPalindrome1(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))
            {
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * 动态规范判断s的所有子串是否是回文
     * @param s 
     */
    public static boolean[][] isPalindrome2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];//默认都为false
        for (int right = 0; right < s.length() ; right++) {
            for (int left = 0; left <=right; left++) {
                if(s.charAt(left)==s.charAt(right)&&(right-left<=2||dp[left+1][right-1]))
                {
                    //1.right-left<=2表示字段长度为2，且s.charAt(left)==s.charAt(right)说明该子串是回文
                    //2.如果right-left>2,且dp[left+1][right-1]=true，说明更小的子串是回文，且首尾也相同，则该子串是回文
                    dp[left][right] = true;
                }
            }
            
        }
        return dp;
    }
}
