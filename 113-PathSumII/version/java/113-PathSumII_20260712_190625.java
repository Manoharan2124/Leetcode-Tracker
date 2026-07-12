// Last updated: 7/12/2026, 7:06:25 PM
1class Solution {
2    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
3        List<List<Integer>> output = new ArrayList<>();
4        dfs(root, targetSum, 0, output, new ArrayList<>());
5        return output;
6    }
7
8    private void dfs(TreeNode root, int targetSum, int curSum,
9                     List<List<Integer>> output, List<Integer> currentPath) {
10        if (root == null) return;
11
12        // Add current node's value to sum and path
13        curSum += root.val;
14        currentPath.add(root.val);
15
16        // If it's a leaf and path sum equals target, add path to result
17        if (root.left == null && root.right == null && curSum == targetSum) {
18            output.add(new ArrayList<>(currentPath));
19        }
20
21        // Recur for children
22        dfs(root.left, targetSum, curSum, output, currentPath);
23        dfs(root.right, targetSum, curSum, output, currentPath);
24
25        // Backtrack: remove current node
26        currentPath.remove(currentPath.size() - 1);
27    }
28}