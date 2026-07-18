// Last updated: 7/18/2026, 10:39:37 AM
1class Solution {
2    public ListNode reverseList(ListNode head) {
3    ListNode prev=null;
4    ListNode curr=head;
5    while(curr!=null){
6        ListNode  temp=curr.next;    //step1
7        curr.next=prev;              //step2
8         prev = curr;                //step3
9        curr=temp;                   //step4
10    }
11    return prev;
12    }
13}