// Last updated: 8/28/2026, 10:09:53 AM
1class Solution {
2    public int countNodes(TreeNode root) {
3        if (root == null)
4            return 0;
5        TreeNode left = root, right = root;
6        int height = 0;
7        while (right != null) {
8            left = left.left;
9            right = right.right;
10            height++;
11        }
12        if (left == null)
13            return (1 << height) - 1;
14        return 1 + countNodes(root.left) + countNodes(root.right);
15    }
16}