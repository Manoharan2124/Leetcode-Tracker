// Last updated: 8/28/2026, 9:20:04 AM
1class Solution {
2    public List<List<Integer>> combinationSum3(int k, int n) {
3        List<List<Integer>> ans = new ArrayList<>();
4        findCombination(k, 1, n, new ArrayList<>(), ans);
5        return ans; 
6    }
7
8    public static void findCombination(int k, int num, int target, ArrayList<Integer> lst, List<List<Integer>> ans) {
9        // If target is reached and k elements are used
10        if (target == 0 && k == 0) {
11            ans.add(new ArrayList<>(lst));
12            return;
13        }
14
15        for (int i = num; i < 10; i++) {
16            if (i > target || k <= 0) break; // Prune unnecessary calls
17            lst.add(i); // Choose the current number
18            findCombination(k - 1, i + 1, target - i, lst, ans); // Recurse
19            lst.remove(lst.size() - 1); // Backtrack
20        }
21    }
22}