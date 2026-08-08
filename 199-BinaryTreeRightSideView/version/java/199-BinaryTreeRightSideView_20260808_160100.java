// Last updated: 8/8/2026, 4:01:00 PM
1class Trie {
2    Node root;
3
4    public Trie() {
5        root = new Node();
6    }
7    
8    public void insert(String word) {
9        root.insert(word, 0);
10    }
11    
12    public boolean search(String word) {
13        return root.search(word, 0);
14    }
15    
16    public boolean startsWith(String prefix) {
17        return root.startsWith(prefix, 0);
18    }
19
20    class Node {
21        Node[] nodes;
22        boolean isEnd;
23
24        Node() {
25            nodes = new Node[26];
26        }
27
28        private void insert(String word, int idx) {
29            if (idx >= word.length()) return;
30            int i = word.charAt(idx) - 'a';
31            if (nodes[i] == null) {
32                nodes[i] = new Node();
33            }
34
35            if (idx == word.length()-1) nodes[i].isEnd = true;
36            nodes[i].insert(word, idx+1);
37        }
38
39        private boolean search(String word, int idx) {
40            if (idx >= word.length()) return false;
41            Node node = nodes[word.charAt(idx) - 'a'];
42            if (node == null) return false;
43            if (idx == word.length() - 1 && node.isEnd) return true;
44
45            return node.search(word, idx+1);
46
47        }
48
49        private boolean startsWith(String prefix, int idx) {
50            if (idx >= prefix.length()) return false;
51            Node node = nodes[prefix.charAt(idx) - 'a'];
52            if (node == null) return false;
53            if (idx == prefix.length() - 1) return true;
54
55            return node.startsWith(prefix, idx+1);
56        }
57    }
58}