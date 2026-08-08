// Last updated: 8/8/2026, 4:05:59 PM
1class Solution {
2    public int rob(int[] nums) {
3        if (nums.length == 1) return nums[0];
4        return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));        
5    }
6
7    private int getMax(int[] nums, int start, int end) {
8        int prevRob = 0, maxRob = 0;
9
10        for (int i = start; i <= end; i++) {
11            int temp = Math.max(maxRob, prevRob + nums[i]);
12            prevRob = maxRob;
13            maxRob = temp;
14        }
15
16        return maxRob;
17    }    
18}