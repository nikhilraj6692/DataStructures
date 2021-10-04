package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.Arrays;
import java.util.List;

/*
some key notes:
an undirected graph has an eurelian path if zero or two vertices have odd degree and all vertices with non-zero degree should belong to a
single connected component (meaning that after all vertices is done with traversal, if any of the vertex remains unvisited
then it is not single connected graph and there may more than 1 connected graphs). an undirected graph has an eurelian circuit if
all vertices have odd degree and all vertices with non-zero degree should belong to a single connected component. an undirected
graph has a eurelian path but not circuit, i.e. exactly two vertices have odd degree and all vertices with non-zero degree should
belong to a single connected component.

An eurelian path is also called eurelian trail. It is a path that visits every edge in a graph exactly only once. An eurelian circuit
is also called eurelian trail if it starts and ends on the same vertex. A directed graph has eurelian cycle if and only if each vertex
has same in and out degree and all of its vertices belong to single connected component
 */
public class Test22CheckWhetherGraphIsAnEulerian {
    public static void main(String[] args) {
        List<Edge<Integer>> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 3),
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 3), new Edge(3, 4));

        // total number of nodes in the graph
        int N = 5;

        // create an undirected graph from the given edges
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraphUndirectedGraph(edges);

        // check if all vertices with a non-zero degree belong to a
        // single connected component
        boolean is_connected = isConnected(graph, N);

        //check for eurelian path and circuit first condition
        int[] count = new int[N];
        countDegreeOfVertices(graph, N, count);

        int oddDegree = 0 ;
        int evenDegree = 0;

        for(int cnt : count){
            if(cnt%2==0)
                evenDegree++;
            else
                oddDegree++;
        }

        if(is_connected && evenDegree==N)
            System.out.println("Graph has an eurelian circuit");
        else
            System.out.println("Graph does not have an eurelian circuit");

        if(is_connected && (oddDegree==0 || oddDegree == 2))
            System.out.println("Graph has an eurelian path");
        else
            System.out.println("Graph does not have an eurelian path");
    }

    private static void countDegreeOfVertices(Graph graph, int n, int[] count) {
        for(int i=0;i<n;i++){
            count[i] = graph.adjList.get(i).size();
        }
    }

    private static boolean isConnected(Graph graph, int n) {
        boolean[] visited = new boolean[n];
        for(int i=0; i< n; i++){
            //only do for vertex with non-zero degree
            if(graph.adjList.get(i).size()>0)
            {
                Test03RecursiveImplementationOfADFS.performRecursiveDFS(graph, i, visited);
                break;
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (!visited[i] && graph.adjList.get(i).size() > 0) {
                return false;
            }
        }
        return true;
    }
}
