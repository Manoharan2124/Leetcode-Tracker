// Last updated: 7/11/2026, 8:36:15 PM
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
17    public List<TreeNode> generateTrees(int n) {
18        if (n == 0) {
19            return new ArrayList<>();
20        }
21        
22        Map<String, List<TreeNode>> memo = new HashMap<>();
23
24        return generateTreesHelper(1, n, memo);        
25    }
26
27    private List<TreeNode> generateTreesHelper(int start, int end, Map<String, List<TreeNode>> memo) {
28        String key = start + "-" + end;
29        if (memo.containsKey(key)) {
30            return memo.get(key);
31        }
32        
33        List<TreeNode> trees = new ArrayList<>();
34        if (start > end) {
35            trees.add(null);
36            return trees;
37        }
38        
39        for (int rootVal = start; rootVal <= end; rootVal++) {
40            List<TreeNode> leftTrees = generateTreesHelper(start, rootVal - 1, memo);
41            List<TreeNode> rightTrees = generateTreesHelper(rootVal + 1, end, memo);
42            
43            for (TreeNode leftTree : leftTrees) {
44                for (TreeNode rightTree : rightTrees) {
45                    TreeNode root = new TreeNode(rootVal);
46                    root.left = leftTree;
47                    root.right = rightTree;
48                    trees.add(root);
49                }
50            }
51        }
52        
53        memo.put(key, trees);
54        return trees;
55    }
56}