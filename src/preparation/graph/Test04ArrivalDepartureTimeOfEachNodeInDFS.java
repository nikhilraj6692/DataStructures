package preparation.graph;

import java.util.Arrays;
import java.util.List;
import preparation.util.Edge;
import preparation.util.Graph;

public class Test04ArrivalDepartureTimeOfEachNodeInDFS
{

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1), new Edge(0, 2), new Edge(2, 3),
            new Edge(2, 4), new Edge(3, 1), new Edge(3, 5),
            new Edge(4, 5), new Edge(6, 7)
        );

        // total number of nodes in the graph
        final int N = 8;

        // build a graph from the given edges
        Graph graph = new Graph(N);
        // array to store the arrival time of vertex
        int[] arrival = new int[N];

        // array to store the departure time of vertex
        int[] departure = new int[N];
        boolean[] discovered = new boolean[N];
        int time = -1;

        // Perform DFS traversal from all undiscovered nodes to
        // cover all unconnected components of a graph
        for (int i = 0; i < N; i++)
        {
            if (!discovered[i])
            {
                time = performDFS(graph, i, discovered, arrival, departure, time);
            }
        }

        // print arrival and departure time of each
        // vertex in DFS
        for (int i = 0; i < N; i++)
        {
            System.out.println("Vertex " + i + " (" + arrival[i]
                + ", " + departure[i] + ")");
        }
    }

    private static int performDFS(Graph graph, int src, boolean[] discovered, int[] arrival,
        int[] departure, int time)
    {
        arrival[src] = ++time;
        discovered[src] = true;

        for (int dest : graph.adjList.get(src))
        {
            if (!discovered[src])
            {
                time = performDFS(graph, dest, discovered, arrival, departure, time);
            }
        }

        departure[src] = ++time;

        return time;
    }
}
