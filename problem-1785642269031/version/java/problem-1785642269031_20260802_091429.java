// Last updated: 8/2/2026, 9:14:29 AM
1class Solution {
2    public int countRatioSubarrays(int[] nums, int a, int b) {
3        int n = nums.length;
4        int count = 0;
5        for(int i=0;i<n;i++) {
6            int evenCount = 0;
7            int oddCount = 0;
8            for(int j=i;j<n;j++) {
9                if(nums[j]%2==0) {
10                    evenCount++;
11                }else {
12                    oddCount++;
13                }
14                if(oddCount >0 && (long) evenCount*b<=(long) oddCount*a){
15                    count++;
16                }
17            }
18        }
19        return count;
20    }
21}