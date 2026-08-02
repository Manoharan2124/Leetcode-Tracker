// Last updated: 8/2/2026, 2:40:16 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 * int val;
5 * ListNode next;
6 * ListNode() {}
7 * ListNode(int val) { this.val = val; }
8 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode sortList(ListNode head) {
13        // Base case: 0 or 1 element is already sorted
14        if (head == null || head.next == null) {
15            return head;
16        }
17        
18        // Step 1: Split the list into two halves
19        ListNode mid = FindMid(head);
20        ListNode midNext = mid.next;
21        mid.next = null; // Break the bond
22        
23        // Step 2: Recursively sort each half
24        ListNode left = sortList(head);
25        ListNode right = sortList(midNext);
26        
27        // Step 3: Merge the sorted halves
28        return merge(left, right);
29    }
30
31    // Helper function to find the middle node using slow and fast pointers
32    ListNode FindMid(ListNode head) {
33        ListNode slow = head;
34        ListNode fast = slow.next;
35        
36        while (fast != null && fast.next != null) {
37            slow = slow.next;
38            fast = fast.next.next;
39        }
40        return slow;
41    }
42
43    // Helper function to merge two sorted linked lists recursively
44    ListNode merge(ListNode left, ListNode right) {
45        if (left == null) return right;
46        if (right == null) return left;
47        
48        if (left.val < right.val) {
49            left.next = merge(left.next, right);
50            return left;
51        } else {
52            right.next = merge(left, right.next);
53            return right;
54        }
55    }
56}