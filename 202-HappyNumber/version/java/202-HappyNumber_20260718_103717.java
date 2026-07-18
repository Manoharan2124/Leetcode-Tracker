// Last updated: 7/18/2026, 10:37:17 AM
1import java.util.LinkedList;
2
3class Solution {
4    public boolean isHappy(int n) {
5        
6        int slow = n;
7        int fast = n;
8//while loop is not used here because initially slow and 
9//fast pointer will be equal only, so the loop won't run.
10        do {
11//slow moving one step ahead and fast moving two steps ahead
12
13            slow = square(slow);
14            fast = square(square(fast));
15        } while (slow != fast);
16
17//if a cycle exists, then the number is not a happy number
18//and slow will have a value other than 1
19
20        return slow == 1;
21    }
22    
23//Finding the square of the digits of a number
24
25    public int square(int num) {
26        
27        int ans = 0;
28        
29        while(num > 0) {
30            int remainder = num % 10;
31            ans += remainder * remainder;
32            num /= 10;
33        }
34        
35        return ans;
36    }
37}