// Last updated: 8/28/2026, 9:54:44 AM
1import java.util.HashSet;
2import java.util.Set;
3
4class Solution {
5    public boolean containsNearbyDuplicate(int[] nums, int k) {
6        Set<Integer> set = new HashSet<>();
7        
8        for (int i = 0; i < nums.length; i++) {
9            // Remove the element that is now outside the window
10            if (i > k) {
11                set.remove(nums[i - k - 1]);
12            }
13            
14            // Try to add the current element. If it fails, a duplicate exists.
15            if (!set.add(nums[i])) {
16                return true;
17            }
18        }
19        
20        return false;
21    }
22}