package leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public  Set<String> findWords(char[][] board, String[] words) {
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
        return result;
    }

    public static void backTrace(char[][] board, int row, int col, int rowLength, int colLength, Set<String> result, Trie trie, boolean[][] visit, String s) {
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

    class Trie {

        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.contains(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
            node.value = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return pre(word)!=null && pre(word).isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return pre(prefix)!=null;
        }

        public TrieNode pre(String s)
        {
            TrieNode node = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(node.get(c)==null){
                    return null;
                }
                node = node.get(c);
            }
            return node;
        }
    }
    class TrieNode {
        public  String value;
        private TrieNode[] nodes;
        private boolean isEnd;
        public TrieNode()
        {
            nodes = new TrieNode[26];
        }

        public boolean contains(char c)
        {
            return nodes[c-'a'] !=null;
        }
        public void put(char c,TrieNode node)
        {
            nodes[c-'a'] = node;
        }
        public TrieNode get(char c){
            return nodes[c - 'a'];
        }
        public  void setEnd()
        {
            isEnd = true;
        }
        public boolean isEnd()
        {
            return isEnd;
        }}
}
