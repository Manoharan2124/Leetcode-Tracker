// Last updated: 7/12/2026, 7:14:45 PM
1class Solution {
2    public List<List<String>> partition(String s) {
3        //m1: backtracking
4        //REASON : 'all' psbl ->backtracking
5
6        List<List<String>> ans = new ArrayList<>();
7        List<String> temp = new ArrayList<>();
8        
9        solve(s, 0, temp, ans);
10        return ans;
11    }
12
13    static void solve(String s, int start, List<String> temp , List<List<String>> ans) {
14        //base case
15        if (start >= s.length()) {
16            ans.add(new ArrayList<>(temp));
17            return;
18        }
19
20        for (int i = start; i < s.length(); i++) {
21            //do 
22            String str = s.substring(start, i + 1);
23
24            if (ispalindrome(str)) {
25                temp.add(str);
26                solve(s, i + 1, temp, ans);
27                temp.remove(temp.size() - 1);
28            }
29
30            
31        }
32    }
33
34    static boolean ispalindrome(String str) {
35        int l = 0, r = str.length() - 1;
36
37        while (l < r) {
38            if (str.charAt(l) != str.charAt(r))
39                return false;
40            l++;
41            r--;
42        }
43
44        return true;
45    }
46}