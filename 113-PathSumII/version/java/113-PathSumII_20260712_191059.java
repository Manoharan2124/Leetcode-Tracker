// Last updated: 7/12/2026, 7:10:59 PM
1class Solution {
2    public int minimumTotal(List<List<Integer>> tri) {
3        for (int i = tri.size() - 2; i >= 0; i--)
4            for (int j = 0; j < tri.get(i).size(); j++)
5                tri.get(i).set(j, tri.get(i).get(j) + Math.min(
6                    tri.get(i + 1).get(j),
7                    tri.get(i + 1).get(j + 1)
8                ));
9        return tri.get(0).get(0);
10    }
11}
12