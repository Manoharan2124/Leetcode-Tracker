// Last updated: 8/8/2026, 4:05:22 PM
1import java.util.*;
2
3public class Solution {
4    private static final int R = 0, C = 1;
5    private final int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};
6
7    private static class TrieNode {
8        TrieNode[] children = new TrieNode[26];
9        String word = null; 
10    }
11
12    private TrieNode buildTrie(String[] words) {
13        TrieNode root = new TrieNode();
14        for (String w : words) {
15            TrieNode node = root;
16            for (char ch : w.toCharArray()) {
17                int idx = ch - 'a';
18                if (node.children[idx] == null) node.children[idx] = new TrieNode();
19                node = node.children[idx];
20            }
21            node.word = w;
22        }
23        return root;
24    }
25
26    public List<String> findWords(char[][] board, String[] words) {
27        if (board == null || board.length == 0 || words == null || words.length == 0)
28            return Collections.emptyList();
29
30        int m = board.length, n = board[0].length;
31        TrieNode root = buildTrie(words);
32        Set<String> found = new HashSet<>();
33
34        for (int i = 0; i < m; ++i) {
35            for (int j = 0; j < n; ++j) {
36                int idx = board[i][j] - 'a';
37                if (idx >= 0 && idx < 26 && root.children[idx] != null) {
38                    dfs(board, i, j, root, found);
39                }
40            }
41        }
42        return new ArrayList<>(found);
43    }
44
45    private void dfs(char[][] board, int r, int c, TrieNode parent, Set<String> found) {
46        char ch = board[r][c];
47        int ci = ch - 'a';
48        TrieNode node = parent.children[ci];
49        if (node == null) return;
50
51        if (node.word != null) {
52            found.add(node.word);
53            node.word = null;
54        }
55
56        board[r][c] = '#';
57
58        for (int[] d : DIRS) {
59            int nr = r + d[R], nc = c + d[C];
60            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
61            char nxt = board[nr][nc];
62            if (nxt == '#') continue;
63            int nxtIdx = nxt - 'a';
64            if (nxtIdx < 0 || nxtIdx >= 26) continue;
65            if (node.children[nxtIdx] != null) {
66                dfs(board, nr, nc, node, found);
67            }
68        }
69
70        board[r][c] = ch;
71
72        if (node.word == null && noChildren(node)) {
73            parent.children[ci] = null;
74        }
75    }
76
77    private boolean noChildren(TrieNode node) {
78        for (TrieNode ch : node.children) {
79            if (ch != null) return false;
80        }
81        return true;
82    }
83}