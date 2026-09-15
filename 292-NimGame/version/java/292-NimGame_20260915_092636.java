// Last updated: 9/15/2026, 9:26:36 AM
1class Solution {
2    public int findDuplicate(int[] nums) {
3        int slow = nums[0];
4        int fast = nums[0];
5
6        while (true) {
7            slow = nums[slow];
8            fast = nums[nums[fast]];
9
10            if (slow == fast) {
11                break;
12            }
13        }
14
15        int slow2 = nums[0];
16
17        while (slow != slow2) {
18            slow = nums[slow];
19            slow2 = nums[slow2];
20        }
21
22        return slow;        
23    }
24}