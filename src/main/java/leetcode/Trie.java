package leetcode;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }

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
