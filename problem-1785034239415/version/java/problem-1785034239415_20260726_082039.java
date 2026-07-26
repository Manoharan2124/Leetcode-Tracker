// Last updated: 7/26/2026, 8:20:39 AM
1class Solution {
2    public int largestInteger(int n, int s) {
3        if(s>9*n) {
4            return -1;
5        }
6        if(s==0){
7            return 0;
8        }
9        StringBuilder sb = new StringBuilder();
10        for(int i = 0;i<n;i++){
11            if(s>=9){
12                sb.append(9);
13                s-=9;
14            }else{
15                sb.append(s);
16                s=0;
17            }
18        }
19        return Integer.parseInt(sb.toString());
20    }
21}