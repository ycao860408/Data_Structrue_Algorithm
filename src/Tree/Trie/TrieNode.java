package Tree.Trie;

public class TrieNode {
    //public char c;
    public boolean isWord;
    public TrieNode [] children;
    public TrieNode( ) {
        //this.c = c;
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}
