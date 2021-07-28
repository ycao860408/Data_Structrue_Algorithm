package Tree.Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    public void add(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            int idx = c  - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }

    public boolean contains(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) return false;
            cur = cur.children[idx];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) return false;
            cur = cur.children[idx];
        }
        return true;
    }

    public boolean search(String word) {
        return helper(word, this.root, 0);
    }

    private boolean helper(String word, TrieNode node, int idx) {
        if (idx == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(idx);
        int cIdx = c - 'a';

        if (c != '.') {
            if (node.children[cIdx] == null) return false;
            return helper(word, node.children[cIdx], idx + 1);
        } else {
            for (TrieNode next : node.children) {
                if (next != null) {
                    if (helper(word, next, idx + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
