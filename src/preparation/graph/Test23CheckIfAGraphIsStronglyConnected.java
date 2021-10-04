package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test23CheckIfAGraphIsStronglyConnected {
    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge(0, 4), new Edge(1, 0), new Edge(1, 2),
                new Edge(2, 1), new Edge(2, 4), new Edge(3, 1),
                new Edge(3, 2) , new Edge(4, 3)
        );

        // total number of nodes in the graph
        final int N = 5;
        Graph graph = new Graph(N);
        //for directed graph
        graph.addEdgeToNonWeightedGraph(edges);

        /*
        to check if graph is strongly connected meaning that there is a path from every vertex is reachable from every other
        vertex. Below approach will iterate for all the vertices and check if visited array is having all vertices as visited or
        not. We can do either a BFS or DFS. The time complexity in this case is O(v*(v+e))
         */
        boolean[] visited = new boolean[N];
        boolean isConnected = true;
        for(int i=0; i<N; i++){
            dfs(i, graph, visited);

            for(boolean b : visited)
                if(!b){
                    isConnected = false;
                    break;
                }
        }

        System.out.println(isConnected? "Graph is strongly connected" : "Graph is not strongly connected");

        /*
        To improve time complexity, there is another algorithm, i.e. Kosaraju's DFS based algorithm. The algorithm says that
        if there is a path from any vertex v to other vertices then there would be definitely a path from any other vertices to
        v. So, we do two DFS traversals. One is with the edge from v to any other vertex and other reversed. If any one of the
        traversal has visited array not true from all elements, then graph is not strongly connected. Can also be done by BFS with
        queue approach
         */
        visited = new boolean[N];
        isConnected = checkIfGraphIsConnectedbyKosarajuAlgo(0, graph, visited, N);
        System.out.println(isConnected? "Graph is strongly connected" : "Graph is not strongly connected");
    }

    private static boolean checkIfGraphIsConnectedbyKosarajuAlgo(int src, Graph graph, boolean[] visited, int N) {
        //do dfs first time
        dfs(src, graph, visited);

        for(boolean b : visited)
            if(!b){
                return false;
            }

        //reinitialize graph after reversing edges
        graph = transpose(graph, N);

        Arrays.fill(visited, false);
        dfs(src, graph, visited);

        for(boolean b : visited)
            if(!b){
                return false;
            }

        return true;
    }

    /*
    create link from adjacent vertex to the src vertex with new set of edges in opposite direction
     */
    private static Graph transpose(Graph graph, int size) {
        List<Edge<Integer>> edges = new ArrayList<>();
        for(int i=0; i<size; i++){
            for(int dest : graph.adjList.get(i)){
                edges.add(new Edge<>(dest, i));
            }
        }

        //initialize graph
        Graph g = new Graph(size);
        g.addEdgeToNonWeightedGraph(edges);
        return g;
    }

    private static void dfs(int src, Graph graph, boolean[] visited) {
        visited[src] = true;

        for(int dest : graph.adjList.get(src)) {
            if(!visited[dest])
                dfs(dest, graph, visited);
        }
    }
}
