// Last updated: 7/12/2026, 7:15:18 PM
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>();
9    }
10    public Node(int _val) {
11        val = _val;
12        neighbors = new ArrayList<Node>();
13    }
14    public Node(int _val, ArrayList<Node> _neighbors) {
15        val = _val;
16        neighbors = _neighbors;
17    }
18}
19*/
20
21class Solution {
22    public void dfs(Node node , Node copy , Node[] visited){
23        visited[copy.val] = copy;// store the current node at it's val index which will tell us that this node is now visited
24        
25//         now traverse for the adjacent nodes of root node
26        for(Node n : node.neighbors){
27//             check whether that node is visited or not
28//              if it is not visited, there must be null
29            if(visited[n.val] == null){
30//                 so now if it not visited, create a new node
31                Node newNode = new Node(n.val);
32//                 add this node as the neighbor of the prev copied node
33                copy.neighbors.add(newNode);
34//                 make dfs call for this unvisited node to discover whether it's adjacent nodes are explored or not
35                dfs(n , newNode , visited);
36            }else{
37//                 if that node is already visited, retrieve that node from visited array and add it as the adjacent node of prev copied node
38//                 THIS IS THE POINT WHY WE USED NODE[] INSTEAD OF BOOLEAN[] ARRAY
39                copy.neighbors.add(visited[n.val]);
40            }
41        }
42        
43    }
44    public Node cloneGraph(Node node) {
45        if(node == null) return null; // if the actual node is empty there is nothing to copy, so return null
46        Node copy = new Node(node.val); // create a new node , with same value as the root node(given node)
47        Node[] visited = new Node[101]; // in this question we will create an array of Node(not boolean) why ? , because i have to add all the adjacent nodes of particular vertex, whether it's visited or not, so in the Node[] initially null is stored, if that node is visited, we will store the respective node at the index, and can retrieve that easily.
48        Arrays.fill(visited , null); // initially store null at all places
49        dfs(node , copy , visited); // make a dfs call for traversing all the vertices of the root node
50        return copy; // in the end return the copy node
51    }
52}