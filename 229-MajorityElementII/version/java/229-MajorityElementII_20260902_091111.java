// Last updated: 9/2/2026, 9:11:11 AM
1class MyQueue {
2    private Stack<Integer> input;
3    private Stack<Integer> output;
4
5    public MyQueue() {
6        input = new Stack<>();
7        output = new Stack<>();
8    }
9
10    public void push(int x) {
11        input.push(x);
12    }
13
14    public int pop() {
15        peek();
16        return output.pop();
17    }
18
19    public int peek() {
20        if (output.isEmpty()) {
21            while (!input.isEmpty()) {
22                output.push(input.pop());
23            }
24        }
25        return output.peek();
26    }
27
28    public boolean empty() {
29        return input.isEmpty() && output.isEmpty();
30    }
31}