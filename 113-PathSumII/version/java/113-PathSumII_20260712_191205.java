// Last updated: 7/12/2026, 7:12:05 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int buy1 = -prices[0];
4        int sell1 = 0;
5        int buy2 = -prices[0];
6        int sell2 = 0;
7
8        for (int i = 1; i < prices.length; i++) {
9            int price = prices[i];
10            buy1 = Math.max(buy1, -price);
11            sell1 = Math.max(sell1, buy1 + price);
12            buy2 = Math.max(buy2, sell1 - price);
13            sell2 = Math.max(sell2, buy2 + price);
14        }
15
16        return sell2;        
17    }
18}