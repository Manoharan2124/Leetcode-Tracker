// Last updated: 9/20/2026, 9:18:39 AM
1class Solution {
2    public long countIntersectingIntervals(int[][] intervals) {
3        int n = intervals.length;
4        int[] starts = new int[n];
5        for(int i=0;i<n;i++) {
6            starts[i] = intervals[i][0];
7        }
8        Arrays.sort(starts);
9        long nonIntersectingPairs = 0;
10        for(int[] interval : intervals) {
11            int end = interval[1];
12            int countAfter = n-upperBound(starts, end);
13            nonIntersectingPairs += countAfter;
14        }
15        long totalPairs = (long) n*(n-1)/2;
16        return totalPairs - nonIntersectingPairs;
17    }
18    private int upperBound(int[] arr, int target) {
19        int low = 0, high = arr.length;
20        while (low < high) {
21            int mid = low + (high - low)/2;
22            if(arr[mid] <= target) {
23                low = mid + 1;
24            }else {
25                high = mid;
26            }
27        }
28        return low;
29    }
30}