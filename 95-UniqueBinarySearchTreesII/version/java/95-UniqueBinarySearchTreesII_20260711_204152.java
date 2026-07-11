// Last updated: 7/11/2026, 8:41:52 PM
1class Solution {
2
3    private int postIdx;
4    private HashMap<Integer, Integer> map;
5
6    public TreeNode buildTree(int[] inorder, int[] postorder) {
7        map = new HashMap<>();
8
9        for (int i = 0; i < inorder.length; i++) {
10            map.put(inorder[i], i);
11        }
12
13        postIdx = postorder.length - 1;
14        return build(postorder, 0, inorder.length - 1);
15    }
16
17    private TreeNode build(int[] postorder, int left, int right) {
18        if (left > right) {
19            return null;
20        }
21
22        int rootVal = postorder[postIdx--];
23        TreeNode root = new TreeNode(rootVal);
24
25        int mid = map.get(rootVal);
26
27        root.right = build(postorder, mid + 1, right);
28        root.left = build(postorder, left, mid - 1);
29
30        return root;
31    }
32}