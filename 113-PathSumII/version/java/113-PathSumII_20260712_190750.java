// Last updated: 7/12/2026, 7:07:50 PM
1class Solution {
2    public void flatten(TreeNode root) {
3        TreeNode curr = root;
4
5        while (curr != null) {
6            if (curr.left != null) {
7                TreeNode prev = curr.left;
8
9                while (prev.right != null) {
10                    prev = prev.right;
11                }
12
13                prev.right = curr.right;
14                curr.right = curr.left;
15                curr.left = null;
16            }
17
18            curr = curr.right;
19        }
20    }
21}