// Last updated: 8/8/2026, 3:52:19 PM
1class Solution {
2    public List<String> findRepeatedDnaSequences(String s) {
3        Set seen = new HashSet(), repeated = new HashSet();
4        for(int i = 0; i + 9 < s.length(); i++) {
5            String sequence = s.substring(i, i + 10);
6            if(!seen.add(sequence)) repeated.add(sequence);
7        }
8        return new ArrayList(repeated);
9    }
10}