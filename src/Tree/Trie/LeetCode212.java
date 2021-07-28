package Tree.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode212 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    private class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            this.word = null;
            this.children = new TrieNode[26];
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode res = new TrieNode();
        for (String str : words) {
            TrieNode cur = res;
            for (char c : str.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new TrieNode();
                }
                cur = cur.children[idx];
            }
            cur.word = str;
        }
        return res;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) return new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(i, j, res, visited, board, root);
            }
        }
        List<String> finalRes = new ArrayList<>();
        for (String item : res) {
            finalRes.add(item);
        }
        return finalRes;
    }

    private void helper(int x, int y, Set<String> res, boolean[][] visited, char[][] board, TrieNode node) {
        int m = board.length, n = board[0].length;

        char next = board[x][y];
        TrieNode nextNode = node.children[next - 'a'];

        if ( nextNode == null ) return;
        if (nextNode.word != null) {
            res.add(nextNode.word);
        }
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                helper(nx, ny, res, visited, board, nextNode);
            }
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'a','b','c','e'},
                {'s','f','e','s'},
                {'a', 'd','e','e'}
        };
        String[] words = new String[] {"abceseeefs","abceseedasfe"};
        LeetCode212 solution = new LeetCode212();
        List<String> result = solution.findWords(board, words);
        for (String item : result) {
            System.out.println(item);
        }
    }

}


