// Last updated: 7/10/2026, 2:54:36 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        if (head == null || left == right) {
14            return head;
15        }
16        ListNode dummy = new ListNode(0);
17        dummy.next = head;
18        ListNode prev = dummy;
19        for(int i = 0;i<left-1;i++){
20            prev = prev.next;
21        }
22        ListNode cur = prev.next;
23        for(int i=0;i<right-left;i++) {
24            ListNode temp = cur.next;
25            cur.next = temp.next;
26            temp.next = prev.next;
27            prev.next = temp;
28        }
29        return dummy.next;
30    }
31}