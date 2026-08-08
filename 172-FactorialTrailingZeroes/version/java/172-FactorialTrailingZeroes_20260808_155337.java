// Last updated: 8/8/2026, 3:53:37 PM
1import java.util.*;
2class Solution{
3public void rotate(int[]nums,int k){
4int n=nums.length;
5k%=n;
6reverse(nums,0,n-1);
7reverse(nums,0,k-1);
8reverse(nums,k,n-1);
9}
10private void reverse(int[]nums,int start,int end){
11while(start<end){
12int temp=nums[start];
13nums[start]=nums[end];
14nums[end]=temp;
15start++;
16end--;
17}
18}
19}