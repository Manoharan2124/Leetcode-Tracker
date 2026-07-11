// Last updated: 7/11/2026, 8:42:23 PM
1class Solution {
2    public List<List<Integer>> levelOrderBottom(TreeNode root) {
3        List<List<Integer>> res = new ArrayList<>();
4        if (root == null) return res;
5
6        Queue<TreeNode> queue = new LinkedList<>();
7        queue.add(root);
8
9        while (!queue.isEmpty()) {
10            int level = queue.size();
11            List<Integer> current = new ArrayList<>();
12
13            for (int i = 0; i < level; i++) {
14                TreeNode curr = queue.poll();
15                current.add(curr.val);
16                if (curr.left != null) queue.offer(curr.left);
17                if (curr.right != null) queue.offer(curr.right);
18            }
19
20            res.add(0, current); // Insert at beginning
21        }
22
23        return res;
24    }
25}