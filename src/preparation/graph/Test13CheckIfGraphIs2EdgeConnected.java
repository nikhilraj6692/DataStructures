package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;
import preparation.util.Pair;

import java.util.Arrays;
import java.util.List;

public class Test13CheckIfGraphIs2EdgeConnected {
    public static void main(String[] args) {
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge(0, 2), new Edge(1, 2),
                new Edge(2, 3), new Edge(2, 4),
                new Edge(3, 4), new Edge(3, 5)
        );

        // total number of nodes in the graph
        final int N = 6;
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraphUndirectedGraph(edges);

        checkIfGraphIs2EdgeConnected(graph, N);
    }

    /*
    A graph is NOT called 2 edge connected graph, if removal of any edge (we can call such edges as bridge also) (note not removal of
    vertices) results in  disconnected graph (a graph is connected if any vertex can be reached from any other vertex). One naive
    approach is to iterate edges list and for each edge removal, do dfs or bfs against all vertices and check if there is any
    vertex which remains unvisited. If yes, then the graph is NOT 2 edge disconnected. However, this approach is too lengthy so
    another approach is to maintain a noOfEdges array in which against each vertex(index) note the edge connected to it and
    fill in noOfEdges array. If for any index, the number of edge is equal to 1, then the graph is NOT 2-edge connected graph
     */
    private static boolean checkIfGraphIs2EdgeConnected(Graph graph, int n) {
        int[] noOfEdges = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0;i<n; i++){
            noOfEdges[i] =graph.adjList.get(i).size();
        }

        boolean bridgeFound = false;

        for(int i=0; i< noOfEdges.length; i++){
            if(noOfEdges[i] == 1){
                bridgeFound = true;

                //find associated bridge
                System.out.println(i + "," + graph.adjList.get(i).get(0));
            }
        }

        if(bridgeFound)
            System.out.println("Graph is 2-edge connected");
        else
            System.out.println("Graph is not 2-edge connected");

        return false;
    }
}
