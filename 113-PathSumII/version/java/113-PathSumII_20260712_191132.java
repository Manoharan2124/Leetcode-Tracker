// Last updated: 7/12/2026, 7:11:32 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int profit = 0;
4
5        // Sum all positive adjacent differences.
6        for (int i = 1; i < prices.length; i++) {
7            if (prices[i] > prices[i - 1]) {
8                profit += prices[i] - prices[i - 1];
9            }
10        }
11
12        return profit;
13    }
14}