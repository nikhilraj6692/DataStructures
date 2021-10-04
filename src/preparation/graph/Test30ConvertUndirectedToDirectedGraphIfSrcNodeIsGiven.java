package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.*;

public class Test30ConvertUndirectedToDirectedGraphIfSrcNodeIsGiven {
    public static void main(String[] args) {
        List<Edge<Integer>> edges = Arrays.asList(new Edge<>(1, 2), new Edge<>(1, 3),
                new Edge<>(2, 4), new Edge<>(3, 4),
                new Edge<>(3, 5), new Edge<>(4, 5),
                new Edge<>(4, 6));

        // total number of nodes in the graph
        int N = 7;

        // create an undirected graph from the above edges
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraphUndirectedGraph(edges);

        // given vertex
        int vertex = 1;

        /*
        the idea is to do bfs or dfs from the vertex and create new directed edges as and when we visit them
         */
        edges = BFS(graph, N, vertex);

        // create a new directed graph
        Graph digraph = new Graph(N);
        digraph.addEdgeToNonWeightedGraph(edges);

        boolean[] visited = new boolean[N];
        Test03RecursiveImplementationOfADFS.performRecursiveDFS(graph, vertex, visited);
    }

    private static List<Edge<Integer>> BFS(Graph graph, int n, int vertex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        boolean[] visited = new boolean[n];
        List<Edge<Integer>> edges = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;
            for(int dest: graph.adjList.get(curr)){
                if(!visited[dest]){
                    visited[dest] = true;
                    q.add(dest);
                    edges.add(new Edge<>(curr, dest));
                }

            }
        }

        return edges;
    }
}
