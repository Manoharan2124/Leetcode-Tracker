// Last updated: 7/18/2026, 10:25:15 AM
1class Solution {
2    public int maxPathSum(TreeNode root) {
3        int[] res = { root.val };
4        dfs(root, res);
5        return res[0];
6    }
7
8    private int dfs(TreeNode node, int[] res) {
9        if (node == null) {
10            return 0;
11        }
12
13        // Recursively compute the maximum sum of the left and right subtree paths.
14        int leftSum = Math.max(0, dfs(node.left, res));
15        int rightSum = Math.max(0, dfs(node.right, res));
16
17        // Update the maximum path sum encountered so far (with split).
18        res[0] = Math.max(res[0], leftSum + rightSum + node.val);
19
20        // Return the maximum sum of the path (without split).
21        return Math.max(leftSum, rightSum) + node.val;
22    }    
23}