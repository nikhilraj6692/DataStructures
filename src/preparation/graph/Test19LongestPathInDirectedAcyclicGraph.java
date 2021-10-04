package preparation.graph;

import preparation.util.Edge;
import preparation.util.GNode;
import preparation.util.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
can be done in a linear time for directed acyclic graph but may be a np-hard problem for directed graph which does not mention
anything about cycle
 */
public class Test19LongestPathInDirectedAcyclicGraph {
    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge(0, 6, 2), new Edge(1, 2, -4),
                new Edge(1, 4, 1), new Edge(1, 6, 8),
                new Edge(3, 0, 3), new Edge(3, 4, 5),
                new Edge(5, 1, 2), new Edge(7, 0, 6),
                new Edge(7, 1, -1), new Edge(7, 3, 4),
                new Edge(7, 5, -4)
        );



        // total number of nodes in the graph
        final int N = 8;
        int src = 7;

        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[src] = 0;

        int[] parent = new int[N];
        Arrays.fill(parent, -1);

        doBellmanFordForLongestPath(edges, distance, N, parent);
        System.out.print("\n------------------------------\n");
        /*
        There is yet another to do it in linear time. First sort the vertices in topological sort and then call bellman ford algo
        while popping each element from the stack
         */
        Graph graph = new Graph(N);
        graph.addEdgeToWeightedGraph(edges);

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];

        for(int i=0;i <N; i++) {
            if(!visited[i])
                Test06TopologicalSorting.performTopologicalSort(graph, visited, stack, i);
        }


        distance = new int[N];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[src] = 0;

        parent = new int[N];
        Arrays.fill(parent, -1);
        doBellmanFordForLongestPathWithStack(stack, distance, graph, parent);
    }

    private static void doBellmanFordForLongestPathWithStack(Stack<Integer> stack, int[] distance, Graph graph, int[] parent) {
        while(!stack.isEmpty()){
            int v = stack.pop();

            for(GNode node : graph.adjWeightedList.get(v)){
                int dest = node.dest;
                int weight = node.weight;

                if(distance[v]!=Integer.MIN_VALUE && distance[v] + weight > distance[dest]){
                    distance[dest] = distance[v] + weight;
                    parent[dest] = v;
                }
            }
        }

        System.out.println("Vertex\tCost\tPath(From Source)");
        for(int i=0; i<distance.length; i++){
            System.out.println(i + "\t\t" + distance[i] + "\t\t" + findParentUtil(parent, i));
        }

    }

    private static void doBellmanFordForLongestPath(List<Edge<Integer>> edges, int[] distance, int n, int[] parent) {
        for(int i=1; i<n; i++){
            /*
            instead of iterating through the edges, we can also iterate adjlist.get(n), where n is 0 to adjlist.size()-1 inclusive
             */
            for(Edge edge : edges){
                if(distance[edge.source]!=Integer.MIN_VALUE && distance[edge.source] + edge.weight > distance[edge.destination]){
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                    parent[edge.destination] = edge.source;
                }
            }
        }

        System.out.println("Vertex\tCost\tPath(From Source)");
        for(int i=0; i<distance.length; i++){
            System.out.println(i + "\t\t" + distance[i] + "\t\t" + findParentUtil(parent, i));
        }
    }

    private static String findParentUtil(int[] parent, int v) {
        StringBuilder pathBuilder = new StringBuilder();
        return findPath(parent, v, pathBuilder).toString();
    }

    private static StringBuilder findPath(int[] parent, int v, StringBuilder pathBuilder) {
        if(parent[v]==-1)
            return pathBuilder.append(v);

        StringBuilder temp = findPath(parent, parent[v], pathBuilder);
        return temp.append("->").append(v);
    }
}
