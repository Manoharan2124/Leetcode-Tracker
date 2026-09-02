// Last updated: 9/2/2026, 8:53:24 AM
1class Solution {
2    public void evaluateOpr(char prevOpr, int num, Deque<Integer> nums) {
3        if (prevOpr == '/')
4            nums.addLast(nums.removeLast() / num);
5        else if (prevOpr == '*')
6            nums.addLast(nums.removeLast() * num);
7        else if (prevOpr == '+')
8            nums.addLast(num);
9        else
10            nums.addLast(num * -1);
11    }
12    
13    
14    public int calculate(String s) {
15        int num = 0;
16        char prevOpr = '+';
17        Deque<Integer> nums = new ArrayDeque<>();
18        
19        
20        for (char ch : s.toCharArray()) {
21            if (ch == ' ')
22                continue;
23            
24            
25            if (Character.isDigit(ch)) {
26                num = num * 10 + ch - '0';
27            } else {
28                evaluateOpr(prevOpr, num, nums);
29                prevOpr = ch;
30                num = 0;
31            }
32        }
33        
34        
35        evaluateOpr(prevOpr, num, nums);
36        num = 0;
37        
38        
39        for (int n : nums)
40            num += n;
41        
42        
43        return num;
44    }
45}