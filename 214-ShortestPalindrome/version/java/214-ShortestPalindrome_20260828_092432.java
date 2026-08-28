// Last updated: 8/28/2026, 9:24:32 AM
1class TopNode {
2    int x;
3    int h;
4    TopNode next;
5    TopNode() {
6    }
7    TopNode(int x, int h) {
8        this.x = x;
9        this.h = h;
10    }
11
12    void insert(TopNode n) {
13        n.next = next;
14        next = n;
15    }
16
17}
18class Solution {
19    static final int LEFT=0, RIGHT=1, HEIGHT=2;
20    public List<List<Integer>> getSkyline(int[][] buildings) {
21        TopNode head = new TopNode(0,0);
22        head.insert(new TopNode(Integer.MAX_VALUE, 0));
23        TopNode start = head;
24        
25        for (int i = 0; i<buildings.length; i++) {
26            int[] b = buildings[i];
27            int bL = buildings[i][LEFT];
28            int bR = buildings[i][RIGHT];
29            int bH = buildings[i][HEIGHT];
30            //System.out.println(Arrays.toString(buildings[i]));
31            while (bL >= start.next.x) { start = start.next; } 
32            //System.out.println(start.toString());
33            for (TopNode t = start ; bR > t.x; t = t.next) {
34                //System.out.println(head.toString());
35                if (bH <= t.h) {
36                    continue;
37                }
38
39                TopNode stop = t;
40                while (stop.next != null && stop.next.x < bR && stop.next.h <= bH ) {
41                    stop = stop.next;
42                }
43                
44                if (bL <= t.x) {
45                    if (bR >= stop.next.x) {
46                        t.next = stop.next;
47                        t.h = bH;
48                    }
49                    else if (t == stop) {
50                        t.insert(new TopNode(bR,t.h));
51                        t.h = bH;
52                        break;
53                    }
54                    else {
55                        stop.x = bR;
56                        t.h = bH;
57                        t.next = stop;
58                        break;
59                    }
60                }
61                else {
62                    if (bR >= stop.next.x) {
63                        if (t == stop) {
64                            t.insert(new TopNode(bL, bH));
65                        }
66                        else {
67                            t.next = stop;
68                            stop.x = bL;
69                            stop.h = bH;
70                        }
71                        break;
72                    }
73                    else if (t == stop) {
74                        t.insert(new TopNode(bL,bH));
75                        t.next.insert(new TopNode(bR,t.h));
76                        break;
77                    }
78                    else {
79                        t.next = stop;
80                        t.insert(new TopNode(bL,bH));
81                        stop.x = bR;
82                        break;
83                    }
84                }
85                t = stop;
86
87            }
88        }
89
90        List<List<Integer>> skyline = new ArrayList<>();
91
92        if (head.h == 0)
93            head = head.next;
94        while (head != null) {
95            int height = head.h;
96            skyline.add(List.of(head.x, height));
97            while ( (head = head.next) != null && head.h == height) {}
98        }
99
100        return skyline;
101    }
102
103}