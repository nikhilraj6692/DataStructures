package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.Arrays;
import java.util.List;

public class Test25FindAMotherOrRootVertexOfAGraph {
    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge<Integer>> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 3), new Edge(3, 0), new Edge(4, 3),
                new Edge(4, 5), new Edge(5, 0));

        // total number of nodes in the graph
        int N = 6;

        // build a directed graph from the given edges
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);

        // find the root vertex in the graph
        int root = findRootVertex(graph, N);

        if (root != -1) {
            System.out.println("The root vertex is " + root);
        }
        else {
            System.out.println("The root vertex does not exist");
        }
    }

    /*
    Case 1:- Undirected Connected Graph : In this case, all the vertices are mother vertices as we can reach to all the other nodes
     in the graph.
    Case 2:- Undirected/Directed Disconnected Graph : In this case, there is no mother vertices as we cannot reach to all the other
    nodes in the graph.
    Case 3:- Directed Connected Graph : In this case, we have to find a vertex -v in the graph such that we can reach to all the
    other nodes in the graph through a directed path.

    One naive approach is to iterate every vertex and find dfs. at the end of each iteration, we check if all vertices are
    visited. If yes, then that is the mother vertex. otherwise check for next vertex and so on...but one other way to do it is
    by making a note of last visited vertex if the vertex is not visited and finally do a dfs for the vertex. if it covers all
    vertices, then it is a mother vertex
     */
    private static int findRootVertex(Graph graph, int n) {
        int lastVisitedVertex=-1;
        boolean[] visited = new boolean[n];

        /*
        doing below because we need to check which vertex can have all visited as true.
         */
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, graph, visited);
                lastVisitedVertex = i;
            }
        }

        //check for dfs of last visited vertex
        Arrays.fill(visited, false);
        dfs(lastVisitedVertex, graph, visited);

        for(int i=0; i< visited.length; i++){
            if(!visited[i])
                return -1;
        }

        return lastVisitedVertex;
    }

    private static void dfs(int src, Graph graph, boolean[] visited) {
        visited[src] = true;

        for(int dest : graph.adjList.get(src)) {
            if(!visited[dest])
                dfs(dest, graph, visited);
        }
    }
}
