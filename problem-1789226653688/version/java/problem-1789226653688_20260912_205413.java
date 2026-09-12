// Last updated: 9/12/2026, 8:54:13 PM
1class Solution {
2    public int countSpecialIntegers(int[] nums) {
3        Map<Integer, List<Integer>> indexMap = new HashMap<>();
4        for(int i=0;i<nums.length;i++) {
5            indexMap.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
6        }
7        int specialCount = 0;
8        for(List<Integer> indices : indexMap.values()) {
9            if(indices.size() == 3) {
10                int i1 = indices.get(0);
11                int i2 = indices.get(1);
12                int i3 = indices.get(2);
13                if((i2 - i1) == (i3-i2)) {
14                    specialCount++;
15                }
16            }
17        }
18        return specialCount;
19    }
20} 