// Last updated: 7/12/2026, 7:08:56 PM
1class Solution {
2    public Node connect(Node root) {
3        if (root == null) return root;
4
5        Queue<Node> q = new LinkedList<>();
6        q.add(root);
7
8        while (!q.isEmpty()) {
9            int level = q.size();
10            while (level-- > 0) {
11                Node curr = q.poll();
12                if (level != 0) curr.next = q.peek();
13                if (curr.left != null) q.add(curr.left);
14                if (curr.right != null) q.add(curr.right);
15            }
16        }
17
18        return root;
19    }
20}