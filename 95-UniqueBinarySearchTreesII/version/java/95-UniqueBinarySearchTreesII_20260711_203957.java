// Last updated: 7/11/2026, 8:39:57 PM
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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18
19        ArrayList<List<Integer>> ans = new ArrayList<>();
20
21        if (root == null) {
22            return ans;
23        }
24
25        Queue<TreeNode> q = new LinkedList<>();
26
27        q.offer(root);
28
29        while (q.size() > 0) {
30
31            int size = q.size();
32
33            ArrayList<Integer> level = new ArrayList<>();
34
35            for (int i = 0; i < size; i++) {
36
37                TreeNode node = q.poll();
38                level.add(node.val);
39
40                if (node.left != null) {
41                    q.offer(node.left);
42                }
43
44                if (node.right != null) {
45                    q.offer(node.right);
46                }
47            }
48
49            ans.add(level);
50        }
51
52        return ans;
53    }
54}