// Last updated: 8/8/2026, 3:51:30 PM
1class Solution {
2    public String largestNumber(int[] nums) {
3        String[] arr = new String[nums.length];
4
5        // Convert to strings once.
6        for (int i = 0; i < nums.length; i++) {
7            arr[i] = String.valueOf(nums[i]);
8        }
9
10        // Core comparator:
11        // a comes before b if (a+b) is lexicographically larger than (b+a).
12        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
13
14        // All-zero case.
15        if (arr[0].equals("0")) return "0";
16
17        StringBuilder sb = new StringBuilder();
18        for (String s : arr) sb.append(s);
19        return sb.toString();
20    }
21}