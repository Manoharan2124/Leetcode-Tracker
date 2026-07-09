// Last updated: 7/9/2026, 3:19:55 PM
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        int count = 0;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count == k) {

            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;

            count = 0;

            while (count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            head.next = reverseKGroup(curr, k);

            return prev;
        }

        return head;
    }
}