// Last updated: 9/24/2026, 10:39:37 AM
1class Solution {
2    public List<Integer> findDisappearedNumbers(int[] nums) {
3        int n = nums.length;
4
5        boolean[] range = new boolean[n + 1];
6
7        for (int num : nums) {
8            range[num] = true;
9        }
10
11        List<Integer> list = new ArrayList<>();
12
13        for (int i = 1; i <= n; i++) {
14            if (!range[i]) {
15                list.add(i);
16            }
17        }
18
19        return list;
20    }
21}