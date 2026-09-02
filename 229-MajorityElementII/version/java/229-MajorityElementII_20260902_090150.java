// Last updated: 9/2/2026, 9:01:50 AM
1class Solution {
2    int count = 0;
3    int ans = 0;
4    public int kthSmallest(TreeNode root, int k) {
5        helper(root, k);
6
7        return ans;
8    }
9
10    private void helper(TreeNode root, int k){
11        if(root == null) return;
12
13        helper(root.left, k);
14
15        count++;
16
17        if(count == k){
18            ans = root.val;
19            return;
20        }
21
22        if(count < k){
23            helper(root.right, k);
24        }
25    }
26}