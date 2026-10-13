// Last updated: 10/13/2026, 9:58:09 PM
1class Solution {
2    public int[] intersect(int[] nums1, int[] nums2) {
3        int l1 = nums1.length;
4        int l2 = nums2.length;
5        int i = 0, j = 0, k = 0;
6        Arrays.sort(nums1);
7        Arrays.sort(nums2);
8        while( i < l1 && j < l2)
9        {
10            if(nums1[i] < nums2[j])
11            {
12                i++;
13            }
14            else if(nums1[i] > nums2[j])
15            {
16                j++;
17            }
18            else
19            {
20                nums1[k++] = nums1[i++];
21                j++;
22            }
23        }
24        return Arrays.copyOfRange(nums1,0,k);
25    }
26}