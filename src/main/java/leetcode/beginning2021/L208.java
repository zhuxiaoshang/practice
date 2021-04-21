package leetcode.beginning2021;
/**
 * @author: zhushang
 * @create: 2021-04-21 11:34
 */
public class L208 {
  TrieNode root;

  public L208(TrieNode root) {
    this.root = new TrieNode('1');
  }

  public void insert(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        TrieNode node = new TrieNode(c);
        cur.children[c - 'a'] = node;
        cur = node;
      } else {
        cur = cur.children[c - 'a'];
      }
    }
    cur.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      TrieNode node = cur.children[c - 'a'];
      if (node == null) return false;
      cur = node;
    }
    return cur.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode cur = root;
    for (char c : prefix.toCharArray()) {
      TrieNode node = cur.children[c - 'a'];
      if (node == null) return false;
      cur = node;
    }
    return true;
  }

  class TrieNode {
    char val;
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(char val) {
      this.val = val;
      children = new TrieNode[26];
    }
  }
}
