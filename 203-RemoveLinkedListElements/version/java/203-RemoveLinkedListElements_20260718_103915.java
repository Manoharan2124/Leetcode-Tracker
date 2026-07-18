// Last updated: 7/18/2026, 10:39:15 AM
1class Solution {
2    public boolean isIsomorphic(String s, String t) {
3        HashMap<Character, Integer> charIndexS = new HashMap<>();
4        HashMap<Character, Integer> charIndexT = new HashMap<>();
5
6        for (int i = 0; i < s.length(); i++) {
7            if (!charIndexS.containsKey(s.charAt(i))) {
8                charIndexS.put(s.charAt(i), i);
9            }
10
11            if (!charIndexT.containsKey(t.charAt(i))) {
12                charIndexT.put(t.charAt(i), i);
13            }
14
15            if (!charIndexS.get(s.charAt(i)).equals(charIndexT.get(t.charAt(i)))) {
16                return false;
17            }
18        }
19
20        return true;        
21    }
22}