package leetcode;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if(visit[start]==0){
                for (int end = start+1; end <=s.length() ; end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visit[start]=1;
            }
        }
        return false;
    }
}
