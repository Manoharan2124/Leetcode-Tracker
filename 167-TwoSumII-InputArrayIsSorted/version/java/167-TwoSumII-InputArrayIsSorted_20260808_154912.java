// Last updated: 8/8/2026, 3:49:12 PM
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3
4        int start = 0;
5        int end = numbers.length - 1;
6
7        while(start < end){
8
9            int sum = numbers[start] + numbers[end];
10
11            if(sum == target){
12                return new int[]{start + 1, end + 1};
13            }
14            else if(sum < target){
15                start++;
16            }
17            else{
18                end--;
19            }
20        }
21
22        return new int[]{-1, -1};
23    }
24}