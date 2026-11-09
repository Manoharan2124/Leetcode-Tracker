// Last updated: 11/9/2026, 2:48:24 PM
1
2class Solution {
3    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
4        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
5        double[] results = new double[queries.size()];
6
7        for (int i = 0; i < queries.size(); i++) {
8            List<String> query = queries.get(i);
9            String dividend = query.get(0);
10            String divisor = query.get(1);
11
12            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
13                results[i] = -1.0;
14            } else {
15                results[i] = bfs(dividend, divisor, graph);
16            }
17        }
18
19        return results;
20    }
21
22    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
23        Map<String, Map<String, Double>> graph = new HashMap<>();
24
25        for (int i = 0; i < equations.size(); i++) {
26            List<String> equation = equations.get(i);
27            String dividend = equation.get(0);
28            String divisor = equation.get(1);
29            double value = values[i];
30
31            graph.putIfAbsent(dividend, new HashMap<>());
32            graph.putIfAbsent(divisor, new HashMap<>());
33            graph.get(dividend).put(divisor, value);
34            graph.get(divisor).put(dividend, 1.0 / value);
35        }
36
37        return graph;
38    }
39
40    private double bfs(String start, String end, Map<String, Map<String, Double>> graph) {
41        Queue<Pair<String, Double>> queue = new LinkedList<>();
42        Set<String> visited = new HashSet<>();
43        queue.offer(new Pair<>(start, 1.0));
44
45        while (!queue.isEmpty()) {
46            Pair<String, Double> pair = queue.poll();
47            String node = pair.getKey();
48            double value = pair.getValue();
49
50            if (node.equals(end)) {
51                return value;
52            }
53
54            visited.add(node);
55
56            for (Map.Entry<String, Double> neighbor : graph.get(node).entrySet()) {
57                String neighborNode = neighbor.getKey();
58                double neighborValue = neighbor.getValue();
59
60                if (!visited.contains(neighborNode)) {
61                    queue.offer(new Pair<>(neighborNode, value * neighborValue));
62                }
63            }
64        }
65
66        return -1.0;
67    }
68}