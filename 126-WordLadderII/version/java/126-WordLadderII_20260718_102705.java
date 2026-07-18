// Last updated: 7/18/2026, 10:27:05 AM
1class Solution {
2    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
3        Set<String> wordSet = new HashSet<>(wordList);
4        if (!wordSet.contains(endWord)) return 0;
5
6        Set<String> beginSet = new HashSet<>();
7        Set<String> endSet = new HashSet<>();
8        Set<String> visited = new HashSet<>();
9
10        beginSet.add(beginWord);
11        endSet.add(endWord);
12        int steps = 1;
13
14        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
15            if (beginSet.size() > endSet.size()) {
16                Set<String> temp = beginSet;
17                beginSet = endSet;
18                endSet = temp;
19            }
20
21            Set<String> nextSet = new HashSet<>();
22
23            for (String word : beginSet) {
24                for (int i = 0; i < word.length(); i++) {
25                    for (char c = 'a'; c <= 'z'; c++) {
26                        if (c == word.charAt(i)) continue;
27
28                        String newWord = word.substring(0, i) + c + word.substring(i + 1);
29                        if (endSet.contains(newWord)) return steps + 1;
30
31                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
32                            visited.add(newWord);
33                            nextSet.add(newWord);
34                        }
35                    }
36                }
37            }
38
39            beginSet = nextSet;
40            steps++;
41        }
42
43        return 0;        
44    }
45}