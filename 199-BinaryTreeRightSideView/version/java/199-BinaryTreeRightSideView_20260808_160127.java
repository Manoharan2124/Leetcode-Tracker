// Last updated: 8/8/2026, 4:01:27 PM
1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3        int minLen = Integer.MAX_VALUE;
4        int left = 0;
5        int curSum = 0;
6
7        for (int right = 0; right < nums.length; right++) {
8            curSum += nums[right];
9
10            while (curSum >= target) {
11                if (right - left + 1 < minLen) {
12                    minLen = right - left + 1;
13                }
14                curSum -= nums[left];
15                left++;
16            }
17        }
18        
19        return minLen != Integer.MAX_VALUE ? minLen : 0;        
20    }
21}