// Last updated: 10/4/2026, 8:32:25 AM
1class Solution {
2    public int minRotations(int n, String s) {
3        if (n==0) return 0;
4        int[] digits = new int[n];
5        for(int i=0;i<n;i++) {
6            digits[i] = s.charAt(i) - '0';
7        }
8        int[] pref = new int[n];
9        pref[0] = getDist(0, digits[0]);
10        for(int i=1;i<n;i++) {
11            pref[i] = pref[i-1] + getDist(digits[i-1], digits[i]);
12        }
13        int[] suffInternal = new int[n];
14        suffInternal[n-1] = 0;
15        for(int i=n-2;i>=0;i--) {
16            suffInternal[i] = suffInternal[i+1] + getDist(digits[i], digits[i+1]);
17        }
18        int minCost = pref[n-1];
19        for(int k=0;k<n;k++) {
20            int currentCost = 0;
21            if(k==0) {
22                currentCost = getDist(0, digits[n-1]) + suffInternal[0];
23            }else{
24                currentCost = pref[k-1] + getDist(digits[k-1], digits[n-1]) + suffInternal[k];
25            }
26            minCost = Math.min(minCost, currentCost);
27        }
28        return minCost;
29    }
30    private int getDist(int a, int b) {
31        int diff = Math.abs(a-b);
32        return Math.min(diff, 10-diff);
33    }
34}