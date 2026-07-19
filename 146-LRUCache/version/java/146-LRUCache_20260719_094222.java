// Last updated: 7/19/2026, 9:42:22 AM
1class LRUCache {
2
3    private class Node {
4        int key, value;
5        Node prev, next;
6
7        Node(int k, int v) {
8            key = k;
9            value = v;
10            prev = null;
11            next = null;
12        }
13    }
14
15    private int capacity;
16    private HashMap<Integer, Node> cache;
17    private Node head;
18    private Node tail;
19
20    public LRUCache(int capacity) {
21        this.capacity = capacity;
22
23        cache = new HashMap<>();
24
25        // Dummy head and tail nodes
26        head = new Node(-1, -1);
27        tail = new Node(-1, -1);
28
29        head.next = tail;
30        tail.prev = head;
31    }
32
33    // Removes a node from its current position
34    private void remove(Node node) {
35        node.prev.next = node.next;
36        node.next.prev = node.prev;
37    }
38
39    // Inserts a node right after head (Most Recently Used)
40    private void insertToFront(Node node) {
41        node.next = head.next;
42        node.prev = head;
43
44        head.next.prev = node;
45        head.next = node;
46    }
47
48    public int get(int key) {
49
50        if (!cache.containsKey(key))
51            return -1;
52
53        Node node = cache.get(key);
54
55        // Move the accessed node to the front
56        remove(node);
57        insertToFront(node);
58
59        return node.value;
60    }
61
62    public void put(int key, int value) {
63
64        // Key already exists
65        if (cache.containsKey(key)) {
66
67            Node node = cache.get(key);
68
69            node.value = value;
70
71            // Move it to the front
72            remove(node);
73            insertToFront(node);
74        }
75
76        // New key
77        else {
78
79            // Cache is full
80            if (cache.size() == capacity) {
81
82                // Least Recently Used node
83                Node lru = tail.prev;
84
85                cache.remove(lru.key);
86                remove(lru);
87            }
88
89            // Create new node
90            Node node = new Node(key, value);
91
92            cache.put(key, node);
93
94            // Insert it as the Most Recently Used
95            insertToFront(node);
96        }
97    }
98}
99
100/**
101 * Your LRUCache object will be instantiated and called as such:
102 * LRUCache obj = new LRUCache(capacity);
103 * int param_1 = obj.get(key);
104 * obj.put(key, value);
105 */