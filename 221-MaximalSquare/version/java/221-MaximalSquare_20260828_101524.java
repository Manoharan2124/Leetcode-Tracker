// Last updated: 8/28/2026, 10:15:24 AM
1class Solution {
2    public TreeNode invertTree(TreeNode root) {
3        if (root == null) {
4            return null;
5        }
6        
7        TreeNode temp = root.left;
8        root.left = root.right;
9        root.right = temp;
10        
11        invertTree(root.left);
12        invertTree(root.right);
13        
14        return root;        
15    }
16}