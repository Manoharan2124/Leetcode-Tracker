// Last updated: 8/8/2026, 4:01:52 PM
1class Solution {
2    public int[] findOrder(int numCourses, int[][] prerequisites) {
3        List<List<Integer>> a=new ArrayList<>();
4        boolean[] vis=new boolean[numCourses];
5        boolean[] rec=new boolean[numCourses];
6        int ind=0;
7        int[] res=new int[numCourses];
8        Stack<Integer> s=new Stack<>();
9        for(int i=0;i<numCourses;i++) a.add(new ArrayList<>());
10        for(int p[]:prerequisites) a.get(p[1]).add(p[0]);
11        for(int i=0;i<numCourses;i++){
12            if(!vis[i]) if(cycle(a,i,vis,rec,s)) return new int[0];
13        }
14        while(!s.isEmpty()) res[ind++]=s.pop();
15        return res;
16    }
17    public boolean cycle(List<List<Integer>> a,int curr,boolean[] vis,boolean[] rec,Stack<Integer> s){
18        vis[curr]=true;
19        rec[curr]=true;
20        for(int i:a.get(curr)){
21            if(!vis[i] && cycle(a,i,vis,rec,s)) return true;
22            else if(rec[i]) return true;
23        }
24        rec[curr]=false;
25        s.push(curr);
26        return false;
27    }
28}