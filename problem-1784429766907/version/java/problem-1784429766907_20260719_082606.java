// Last updated: 7/19/2026, 8:26:06 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    private static class Result {
18        int maxVal;
19        int dominantCount;
20        Result(int maxVal, int dominantCount) {
21            this.maxVal = maxVal;
22            this.dominantCount = dominantCount;
23        }
24    }
25    public int countDominantNodes(TreeNode root) {
26        return solve(root).dominantCount;
27    }
28    private Result solve(TreeNode node) {
29        if(node == null) {
30            return new Result(Integer.MIN_VALUE, 0);
31        }
32        Result leftResult = solve(node.left);
33        Result rightResult = solve(node.right);
34        int currentMax = Math.max(node.val,Math.max(leftResult.maxVal, rightResult.maxVal));
35        int totalDominant = leftResult.dominantCount +rightResult.dominantCount;
36        if(node.val == currentMax) {
37            totalDominant++;
38        }
39        return new Result(currentMax, totalDominant);
40    }
41}