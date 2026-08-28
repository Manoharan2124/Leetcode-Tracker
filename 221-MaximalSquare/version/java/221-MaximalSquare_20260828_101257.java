// Last updated: 8/28/2026, 10:12:57 AM
1class MyStack {
2
3    private Queue<Integer> q;
4
5    public MyStack() {
6        q = new LinkedList<>();
7    }
8
9    public void push(int x) {
10        q.add(x);
11        for (int i = 0; i < q.size() - 1; i++) {
12            q.add(q.poll());
13        }
14    }
15
16    public int pop() {
17        return q.poll();
18    }
19
20    public int top() {
21        return q.peek();
22    }
23
24    public boolean empty() {
25        return q.isEmpty();
26    }
27}