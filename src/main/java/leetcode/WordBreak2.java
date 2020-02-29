package leetcode;

import java.util.*;

public class WordBreak2 {
    static Map<Integer, List<String>> map = new HashMap<>();
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak(s,wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> resultSet = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracing(s, 0, path, resultSet, wordDict);
        return resultSet;
    }

    public static void backtracing(String s, int start, List<String> path, List<String> result, List<String> wordDict) {
        if(map.containsKey(start)){
            path.addAll(map.get(start));
            return;
        }
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i < path.size() - 1) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordDict.contains(s.substring(start, i + 1))) {
                path.add(s.substring(start, i + 1));
                backtracing(s, i + 1, path, result, wordDict);
                path.remove(path.size() - 1);
            }
        }


    }

}
