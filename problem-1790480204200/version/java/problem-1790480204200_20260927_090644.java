// Last updated: 9/27/2026, 9:06:44 AM
1class Solution {
2    public int maxEqualAdjacentPairs(int[] nums) {
3        int initialEqual = 0;
4        Map<Long, Integer> pairCounts = new HashMap<>();
5        for(int i=0;i<nums.length-1;i++) {
6            int a = nums[i];
7            int b = nums[i+1];
8            if(a==b) {
9                initialEqual++;
10            }else {
11                int min = Math.min(a,b);
12                int max = Math.max(a,b);
13                long key = ((long) min << 32) |(max & 0xFFFFFFFFL);
14                pairCounts.put(key, pairCounts.getOrDefault(key, 0) +1);
15            }
16        }
17        int maxGain = 0;
18        for(int count : pairCounts.values()) {
19            if(count > maxGain) {
20                maxGain = count;
21            }
22        }
23        return initialEqual + maxGain;
24    }
25}