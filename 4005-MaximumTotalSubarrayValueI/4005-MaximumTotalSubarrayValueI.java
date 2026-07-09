// Last updated: 7/9/2026, 3:05:15 PM
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minVal = nums[0];
        int maxVal = nums[0];
        for(int num: nums) {
            if(num<minVal) minVal = num;
            if(num>maxVal) maxVal = num;
        }
        long maxDiff = (long) maxVal - minVal;
        return maxDiff * k;
    }
}