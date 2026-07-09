// Last updated: 7/9/2026, 3:05:07 PM
class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;

        int start = Math.max(1, n - k);
        int end = n + k;

        for (int x = start; x <= end; x++) {
            if ((n & x) == 0) {
                sum += x;
            }
        }

        return sum;
    }
}