// Last updated: 10/13/2026, 9:59:23 PM
1import java.util.*;
2
3class Solution {
4    public List<Integer> lexicalOrder(int n) {
5        List<Integer> result = new ArrayList<>();
6        int count = 1;
7
8        for (int i = 0; i < n; i++) {
9            result.add(count);
10            if (count * 10 <= n) {
11                count *= 10;  // Move to next lexicographical level
12            } else {
13                if (count >= n) count /= 10;  // Backtrack if needed
14                count++;
15                while (count % 10 == 0) {
16                    count /= 10;  // Skip trailing zeros
17                }
18            }
19        }
20
21        return result;
22    }
23}