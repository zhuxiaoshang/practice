package leetcode;

public class TrieNode {
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
    }
}
