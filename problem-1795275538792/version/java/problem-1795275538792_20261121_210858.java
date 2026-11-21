// Last updated: 11/21/2026, 9:08:58 PM
1class Solution {
2    public String[] assignUmbrella(int[] rain) {
3        int n = rain.length;
4        String[] answer = new String[n];
5        int aliceCount = 0;
6        int bobCount = 0;
7        for (int i=0;i<n;i++) {
8            boolean aliceNeeds = (i + 1 < n && rain[i] == 1 && rain[i + 1] == 1);
9            boolean bobNeeds = (rain[i] == 1);
10            if(aliceNeeds && bobNeeds) {
11                if(aliceCount <= bobCount) {
12                    answer[i] = "Alice";
13                    aliceCount++;
14                }else {
15                    answer[i] = "Bob";
16                    bobCount++;
17                }
18            }else if (aliceNeeds) {
19                answer[i] = "Alice";
20                aliceCount++;
21            }else if (bobNeeds) {
22                answer[i] = "Bob";
23                bobCount++;
24            }else {
25                answer[i] = "None";
26            }
27        }
28        return answer;
29    }
30}