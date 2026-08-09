// Last updated: 8/9/2026, 8:11:39 AM
1import java.util.Arrays;
2class Solution {
3    public double minPrice(int[] prices, int[] discounts) {
4        Arrays.sort(prices);
5        Arrays.sort(discounts);
6        double totalMinPrices = 0.0;
7        int pIndex = prices.length - 1;
8        int dIndex = discounts.length - 1;
9        while (pIndex >= 0 && dIndex >=0) {
10            double discountPercentage = discounts[dIndex]/100.0;
11            totalMinPrices += prices[pIndex]*(1.0 - discountPercentage);
12            pIndex--;
13            dIndex--;
14        }
15        while (pIndex >=0){
16            totalMinPrices += prices[pIndex];
17            pIndex--;
18        }
19        return totalMinPrices;
20    }
21}