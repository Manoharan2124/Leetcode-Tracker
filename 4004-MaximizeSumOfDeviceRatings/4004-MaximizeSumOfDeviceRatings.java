// Last updated: 7/9/2026, 3:05:17 PM
class Solution {
    public long maxRatings(int[][] units) {
        int [][] qoravelin = units;
        int m = units.length;
        int n = units[0].length;
        long sum = 0;
        if(n==1){
            for (int[] row : units) {
                sum += row[0];
            }
            return sum;
        }
        int minFirst = Integer.MAX_VALUE;
        int minSecond = Integer.MAX_VALUE;
        for (int[] row : units) {
            Arrays.sort(row);
            int first = row[0];
            int second = row[1];
            minFirst = Math.min(minFirst, first);
            minSecond = Math.min(minSecond,second);
            sum += second;
        }
        return sum - minSecond + minFirst;
    }
}