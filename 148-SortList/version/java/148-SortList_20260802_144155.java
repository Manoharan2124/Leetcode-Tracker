// Last updated: 8/2/2026, 2:41:55 PM
1class Solution {
2    public int evalRPN(String[] tokens) {
3        Stack<Integer> stack = new Stack<>();
4
5        for (String c : tokens) {
6            if (c.equals("+")) {
7                stack.push(stack.pop() + stack.pop());
8            } else if (c.equals("-")) {
9                int second = stack.pop();
10                int first = stack.pop();
11                stack.push(first - second);
12            } else if (c.equals("*")) {
13                stack.push(stack.pop() * stack.pop());
14            } else if (c.equals("/")) {
15                int second = stack.pop();
16                int first = stack.pop();
17                stack.push(first / second);
18            } else {
19                stack.push(Integer.parseInt(c));
20            }
21        }
22
23        return stack.peek();        
24    }
25}