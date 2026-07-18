// Last updated: 7/18/2026, 8:35:05 PM
1class Solution {
2    public int minAdjacentSwaps(int[] nums, int a, int b) {
3        long swaps = 0;
4        long countCat1 = 0;
5        long countCat2 = 0;
6        long MOD = 1_000_000_007;
7        for(int num : nums) {
8            if(num<a){
9                swaps += countCat1+countCat2;
10            }
11            else if(num>=a && num<=b) {
12                swaps += countCat2;
13                countCat1++;
14                
15            }
16            else {
17                countCat2++;
18            }
19        }
20        return(int)(swaps % MOD);
21    }
22}