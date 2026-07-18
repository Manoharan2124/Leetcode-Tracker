// Last updated: 7/18/2026, 10:26:31 AM
1class Solution {
2    Map<String, Integer> map;
3    List<List<String>> ans;
4    String beginWord;
5
6    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
7
8        Set<String> set = new HashSet<>(wordList);
9
10        Deque<String> q = new ArrayDeque<>();
11
12        this.beginWord = beginWord;
13
14        q.offer(beginWord);
15
16        set.remove(beginWord);
17
18        map = new HashMap<>();
19        map.put(beginWord, 0);
20
21        while(!q.isEmpty()){
22
23            String word = q.poll();
24
25            int step = map.get(word);
26
27            if(word.equals(endWord))
28                break;
29
30            char[] arr = word.toCharArray();
31
32            for(int i = 0; i < word.length(); i++){
33
34                char original = arr[i];
35
36                for(char ch = 'a'; ch <= 'z'; ch++){
37
38                    arr[i] = ch;
39
40                    String newWord = new String(arr);
41
42                    if(set.contains(newWord)){
43
44                        set.remove(newWord);
45                        q.offer(newWord);
46
47                        map.put(newWord, step + 1);
48                    }
49                }
50
51                arr[i] = original;
52            }
53        }
54
55        ans = new ArrayList<>();
56
57        if(map.containsKey(endWord)){
58
59            List<String> seq = new ArrayList<>();
60            seq.add(endWord);
61
62            dfs(endWord, seq);
63        }
64
65        return ans;
66    }
67
68    private void dfs(String word, List<String> seq){
69
70        if(word.equals(beginWord)){
71
72            List<String> temp = new ArrayList<>(seq);
73
74            Collections.reverse(temp);
75
76            ans.add(temp);
77
78            return;
79        }
80
81        int steps = map.get(word);
82
83        char[] arr = word.toCharArray();
84
85        for(int i = 0; i < word.length(); i++){
86
87            char original = arr[i];
88
89            for(char ch = 'a'; ch <= 'z'; ch++){
90
91                arr[i] = ch;
92
93                String newWord = new String(arr);
94
95                if(map.containsKey(newWord) &&
96                   map.get(newWord) == steps - 1){
97
98                    seq.add(newWord);
99
100                    dfs(newWord, seq);
101
102                    seq.remove(seq.size() - 1);
103                }
104            }
105
106            arr[i] = original;
107        }
108    }
109}