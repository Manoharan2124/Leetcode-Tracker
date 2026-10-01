// Last updated: 10/1/2026, 9:00:59 AM
1class Solution {
2    private HashMap<Long, Integer> memo = new HashMap<>();
3    private int solve(long n) {
4        if (n == 1) return 0;  
5        if (memo.containsKey(n)) return memo.get(n);  
6        int even = Integer.MAX_VALUE;
7        int oddMinus = Integer.MAX_VALUE;
8        int oddPlus = Integer.MAX_VALUE;
9        if (n % 2 == 0) {
10            even = 1 + solve(n / 2);
11        } else {
12            oddMinus = 1 + solve(n - 1);
13            oddPlus = 1 + solve(n + 1);
14        }
15        int result = Math.min(even, Math.min(oddMinus, oddPlus));
16        memo.put(n, result); 
17        return result;
18    }
19    public int integerReplacement(int n) {
20        return solve(n);
21    }
22}