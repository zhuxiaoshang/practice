package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords2 {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        //构造一颗前缀树，并将所有单词添加进去
        Trie trie = new Trie();
        for (String word : words
        ) {

            trie.insert(word);
        }

        int rowLength = board.length;
        int colLength = board[0].length;
        boolean[][] visit = new boolean[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                backTrace(board, i, j, rowLength, colLength, result, trie, visit,"");

            }
        }
        return new ArrayList<>(result);
    }

    public static void backTrace(char[][] board, int row, int col, int rowLength, int colLength, Set<String> result, Trie trie, boolean[][] visit,String s) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || visit[row][col]) {
            //退出条件
            return;
        }
        s += board[row][col];
        visit[row][col] = true;//当前已遍历
        if (!trie.startsWith(s)) {
            //匹配不到前缀，退出
            visit[row][col] = false;
            return;
        }
        if (trie.search(s)) {
            //在前缀树中能找到，满足要求，加入set
            result.add(s);

        }
        //继续向上下左右四个方向遍历
        //up
        backTrace(board, row - 1, col, rowLength, colLength, result, trie, visit,s);
        //down
        backTrace(board, row + 1, col, rowLength, colLength, result, trie, visit,s);
        //left
        backTrace(board, row, col - 1, rowLength, colLength, result, trie, visit,s);
        //right
        backTrace(board, row, col + 1, rowLength, colLength, result, trie, visit,s);
        visit[row][col] = false;//当前节点下一轮遍历可能还会用到
    }

}
