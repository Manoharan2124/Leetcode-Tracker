// Last updated: 9/2/2026, 8:56:36 AM
1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        // Create a frequency map to store the count of each element
4        Map<Integer, Integer> elementCountMap = new HashMap<>();
5        
6        // Iterate through the input array to count element occurrences
7        for (int i = 0; i < nums.length; i++) {
8            elementCountMap.put(nums[i], elementCountMap.getOrDefault(nums[i], 0) + 1);
9        }
10        
11        List<Integer> majorityElements = new ArrayList<>();
12        int threshold = nums.length / 3;
13        
14        // Iterate through the frequency map to identify majority elements
15        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
16            int element = entry.getKey();
17            int count = entry.getValue();
18            
19            // Check if the element count is greater than the threshold
20            if (count > threshold) {
21                majorityElements.add(element);
22            }
23        }
24        
25        return majorityElements;
26    }
27}