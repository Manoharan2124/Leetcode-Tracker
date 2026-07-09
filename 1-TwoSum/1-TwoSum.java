// Last updated: 7/9/2026, 3:20:32 PM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++) {
            for(int j = 0;j<i;j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int []{};
    }
}