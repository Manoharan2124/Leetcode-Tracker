// Last updated: 11/9/2026, 2:48:56 PM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        Map<Character, Integer> count = new HashMap<>();
4        
5        for (char c : t.toCharArray()) {
6            count.put(c, count.getOrDefault(c, 0) + 1);
7        }
8        
9        for (char c : s.toCharArray()) {
10            count.put(c, count.get(c) - 1);
11            if (count.get(c) == 0) {
12                count.remove(c);
13            }
14        }
15        
16        return (char) count.keySet().toArray()[0];        
17    }
18}