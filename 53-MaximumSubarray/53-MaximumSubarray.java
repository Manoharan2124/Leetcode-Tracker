// Last updated: 7/9/2026, 3:19:12 PM
class Solution {
    public int maxSubArray(int[] nums) {
        int bestEnding = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            int val1 = nums[i];
            int val2 = bestEnding + nums[i];
            bestEnding = Math.max(val1, val2);
            ans = Math.max(ans, bestEnding);
        }
        return ans;
    }
}