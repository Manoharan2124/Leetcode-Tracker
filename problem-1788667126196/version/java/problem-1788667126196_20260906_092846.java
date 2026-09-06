// Last updated: 9/6/2026, 9:28:46 AM
1class Solution {
2    public int countGoodRotations(int[] nums) {
3        int n = nums.length;
4        int half = n/2;
5        long totalSum = 0;
6        for(int num : nums) {
7            totalSum += num;
8        }
9        long firstHalfSum = 0;
10        for(int i=0;i<half;i++) {
11            firstHalfSum +=nums[i];
12        }
13        int goodRotationsCount = 0;
14        for(int i=0;i<n;i++) {
15            long lastHalfSum = totalSum - firstHalfSum;
16            if(firstHalfSum > lastHalfSum) {
17                goodRotationsCount++;
18            }
19            firstHalfSum -= nums[i];
20            firstHalfSum += nums[(i+half) %n]; 
21        }
22        return goodRotationsCount;
23    }
24}