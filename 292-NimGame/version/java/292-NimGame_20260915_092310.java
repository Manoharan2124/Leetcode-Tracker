// Last updated: 9/15/2026, 9:23:10 AM
1class Solution {
2    public boolean wordPattern(String pattern, String s) {
3        HashMap<Character, String> hm = new HashMap<>();
4        String arr[] = s.trim().split("\\s+");
5        if (pattern.length() != arr.length) return false;
6        for (int i = 0; i < pattern.length(); i++) {
7            char ch = pattern.charAt(i);
8            if (hm.containsKey(ch)) {
9                if (!hm.get(ch).equals(arr[i])) {
10                    return false;
11                }
12            }
13            else {
14                if (hm.containsValue(arr[i])) 
15                    return false;
16
17                hm.put(ch, arr[i]);
18            }
19        }
20        return true;
21    }
22}