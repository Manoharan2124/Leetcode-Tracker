// Last updated: 9/25/2026, 9:57:06 AM
1class Solution {
2    public int[] intersection(int[] nums1, int[] nums2) {
3        HashSet<Integer> set =new HashSet<>();
4        int result[] = new int[nums2.length];
5        int j = 0;
6        for(int i=0; i<nums1.length; i++){
7             set.add(nums1[i]);
8        }
9
10        for(int i=0; i<nums2.length; i++){
11            if(set.contains(nums2[i])){
12                result[j] = nums2[i];
13                j++;
14                set.remove(nums2[i]);
15            }
16        }
17    
18    int[] finalResult = new int[j];
19        for (int i = 0; i < j; i++) {
20            finalResult[i] = result[i];
21        }
22
23        return finalResult;
24        
25    }
26}