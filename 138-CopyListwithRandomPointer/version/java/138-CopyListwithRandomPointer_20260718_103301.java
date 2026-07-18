// Last updated: 7/18/2026, 10:33:01 AM
1public class Solution {
2    public Node copyRandomList(Node head) {
3        if (head == null) return null;
4        
5        HashMap<Node, Node> oldToNew = new HashMap<>();
6        
7        Node curr = head;
8        while (curr != null) {
9            oldToNew.put(curr, new Node(curr.val));
10            curr = curr.next;
11        }
12        
13        curr = head;
14        while (curr != null) {
15            oldToNew.get(curr).next = oldToNew.get(curr.next);
16            oldToNew.get(curr).random = oldToNew.get(curr.random);
17            curr = curr.next;
18        }
19        
20        return oldToNew.get(head);
21    }
22}