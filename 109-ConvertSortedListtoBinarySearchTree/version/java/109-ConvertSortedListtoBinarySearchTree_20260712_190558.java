// Last updated: 7/12/2026, 7:05:58 PM
1class Solution {
2    public TreeNode sortedListToBST(ListNode head) {
3        if(head==null) return null;
4        if(head.next==null) return new TreeNode(head.val);
5        ListNode slow=head,fast=head,slow_Prev=null;
6        while(fast!=null && fast.next!=null){
7            slow_Prev = slow;
8            slow = slow.next;
9            fast = fast.next.next;
10        }
11        TreeNode root = new TreeNode(slow.val);//Making A Root Node
12        slow_Prev.next = null;//Braeking The Link For L1
13        root.left = sortedListToBST(head);
14        root.right = sortedListToBST(slow.next);
15        return root;
16    }
17}