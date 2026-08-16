// Last updated: 8/16/2026, 8:24:54 AM
1class Solution {
2    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
3        int maxLight = 0;
4        for(int light : lights) {
5            if(light > maxLight) {
6                maxLight = light;
7            }
8        }
9        int maxPenalty = 0;
10        for(int time : arrivalTime) {
11            int r = time % period;
12            if(r>=maxLight) {
13                int currentWait = period - r;
14                if(currentWait > maxPenalty) {
15                    maxPenalty = currentWait;
16                }
17            }
18        }
19        return maxPenalty;
20    }
21}