// Last updated: 11/3/2026, 11:20:00 PM
1class Solution {
2    public boolean canMeasureWater(int x, int y, int target) {
3        // If the target is greater than the sum of both jugs, it's impossible.
4        if (x + y < target) {
5            return false;
6        }
7
8        // Handle edge cases where one or both jugs are 0
9        if (x == 0) {
10            return target == y || target == 0;
11        }
12        if (y == 0) {
13            return target == x || target == 0;
14        }
15
16        while (x != 0) {
17            int temp = x;
18            x = y % x;
19            y = temp;
20        }
21
22        return target % y == 0;
23    }
24}