// Last updated: 8/2/2026, 2:46:04 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int n = nums.length - 1;
4        int last = nums[n];
5        int left = 0, right = n;
6
7        while (left < right) {
8            int mid = (left + right) >> 1;
9            if (nums[mid] > last) left = mid + 1;
10            else right = mid;
11        }
12
13        return nums[left];
14    }
15}