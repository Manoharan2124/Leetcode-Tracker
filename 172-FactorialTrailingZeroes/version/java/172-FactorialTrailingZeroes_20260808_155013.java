// Last updated: 8/8/2026, 3:50:13 PM
1public class BSTIterator {
2    private Stack<TreeNode> stack = new Stack<TreeNode>();
3    
4    public BSTIterator(TreeNode root) {
5        pushAll(root);
6    }
7
8    /** @return whether we have a next smallest number */
9    public boolean hasNext() {
10        return !stack.isEmpty();
11    }
12
13    /** @return the next smallest number */
14    public int next() {
15        TreeNode tmpNode = stack.pop();
16        pushAll(tmpNode.right);
17        return tmpNode.val;
18    }
19    
20    private void pushAll(TreeNode node) {
21        for (; node != null; stack.push(node), node = node.left);
22    }
23}