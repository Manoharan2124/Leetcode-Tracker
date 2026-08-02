// Last updated: 8/2/2026, 8:54:22 AM
1class Solution {
2    public long maxPairStrength(int[] nums) {
3        long maxStrength = 0;
4        int n = nums.length;
5        for(int i=0;i<n;i++){
6            for(int j=i+1;j<n;j++){
7                long num1 = nums[i];
8                long num2 = nums[j];
9                long currentGcd = gcd(num1, num2);
10                long strength = (num1 * num2)/(currentGcd *currentGcd);
11                if(strength > maxStrength){
12                    maxStrength = strength;
13                }
14            }
15        }
16        return maxStrength;
17    }
18    private long gcd(long a, long b) {
19        while (b!=0) {
20            long temp = b;
21            b = a%b;
22            a = temp;
23        }
24        return a;
25    }
26}