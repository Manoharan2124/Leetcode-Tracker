// Last updated: 7/11/2026, 8:40:24 PM
1class Solution {
2    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
3    List<List<Integer>> ans=new ArrayList<>();    
4    if(root==null) return ans;
5    Queue<TreeNode> q=new LinkedList<>();
6    q.add(root);
7    boolean check=true;
8    while(!q.isEmpty()){
9        int size=q.size();
10        List<Integer> current=new ArrayList<>(Collections.nCopies(size,0));
11        for(int i=0;i<size;i++){
12            TreeNode node=q.poll();
13            int idx=check?i:(size-1-i);
14            current.set(idx,node.val);
15            if(node.left!=null) q.add(node.left);
16            if(node.right!=null) q.add(node.right);
17        }
18        check=!check;
19        ans.add(current);
20    }
21    return ans;
22    }
23}