// Last updated: 7/12/2026, 7:12:45 PM
1class Solution {
2    public int longestConsecutive(int[] nums) {
3        Arrays.sort(nums);
4        int n = nums.length;
5        int longest = 0;
6        int count =0;
7        int min = Integer.MIN_VALUE;
8
9        for(int i =0 ;i<n;i++){
10           if(nums[i]-1 == min){
11            count++;
12            min=nums[i];
13           }
14           else if(nums[i] != min){
15            count=1;
16            min = nums[i];
17           }
18           longest = Math.max(longest,count);
19        }
20
21        return longest;
22    }
23}