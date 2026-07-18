// Last updated: 7/18/2026, 10:38:11 AM
1class Solution {
2    public ListNode removeElements(ListNode head, int val) {
3        ListNode ans = new ListNode(0, head);
4        ListNode dummy = ans;
5
6        while (dummy != null) {
7            while (dummy.next != null && dummy.next.val == val) {
8                dummy.next = dummy.next.next;
9            }
10            dummy = dummy.next;
11        }
12
13        return ans.next;        
14    }
15}