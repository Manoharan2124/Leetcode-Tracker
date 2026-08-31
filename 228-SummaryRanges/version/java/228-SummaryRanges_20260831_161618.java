// Last updated: 8/31/2026, 4:16:18 PM
1class Solution {
2    public List<String> summaryRanges(int[] nums) {
3        List<String> list = new ArrayList<>();
4        int len = nums.length;
5        for(int i=0;i<len;i++){
6            int start = nums[i];
7
8            while(i+1 < len && nums[i+1]== nums[i]+1){
9                i++;
10            }
11            if(start==nums[i]){
12                list.add(String.valueOf(start));
13            }else{
14                list.add(start +"->"+nums[i]);
15            }
16        }
17        return list;
18    }
19}