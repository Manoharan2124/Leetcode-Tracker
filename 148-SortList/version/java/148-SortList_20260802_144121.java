// Last updated: 8/2/2026, 2:41:21 PM
1class Solution {
2    // This method returns the maximum number of points that lie on the same line
3    // given a set of points represented by the 2D array points
4    public int maxPoints(int[][] points) {
5        // n is the number of points in the array
6        int n = points.length;
7        
8        // If there are 0 or 1 points, there is at most one line that can be formed
9        // (i.e., the line formed by the single point, or no line if there are no points)
10        if(n <= 2) return n;
11        
12        // Initialize the maximum number of points on a line to 2, since there must be at least 2 points to form a line
13        int ans = 2;
14        
15        // Iterate through all pairs of points
16        for(int i = 0 ;i < n; i++){
17            for(int j = i+1; j < n ; j++){
18                // temp is the number of points on the line formed by point i and point j
19                int temp = 2;
20                // Check if any other points are on the same line as point i and point j
21                for(int k = j+1 ; k<n ; k++ ){                   
22                    // Check if point k is on the same line as point i and point j
23                    // This is done by checking if the slope between point i and point k is equal to the slope between point i and point j
24                    int x = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
25                    int y = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);
26                    if(x == y){
27                        // If the slopes are equal, point k is on the same line as point i and point j
28                        temp++;
29                    }
30                }
31                // Update the maximum number of points on a line if necessary
32                if(temp > ans){
33                    ans = temp;
34                }
35            }
36        }   
37        // Return the maximum number of points on a line
38        return ans;
39    }
40}