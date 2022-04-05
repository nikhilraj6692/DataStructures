package preparation.graph;

import java.util.Arrays;
import java.util.List;
import preparation.util.Edge;
import preparation.util.Graph;

/*
As we know that BFS only works with graphs with same weight or no weight. For weighted graphs,
there are different other algo. But
for BFS if the weights are in multiple of some integer x, like if a graph as 1,2,3 weight edges,
then we can achieve bfs by splitting
edges into n edges where edge weight is equal to n*x and x is base weight. like 3 can be split
into 3 edges with each of weight 1.
Then it can be easily traversed via bfs
 */
public class Test32ShortestPathForWeightedGraphsUsingBFS
{

    public static void main(String[] args)
    {
        int baseEdgeWeight = 1;

        // List of graph edges as per the above diagram
        List<Edge<Integer>> edges = Arrays.asList(
            new Edge(0, 1, 3 * baseEdgeWeight), new Edge(0, 4, 1 * baseEdgeWeight),
            new Edge(1, 2, 1 * baseEdgeWeight), new Edge(1, 3, 3 * baseEdgeWeight),
            new Edge(1, 4, 1 * baseEdgeWeight), new Edge(4, 2, 2 * baseEdgeWeight),
            new Edge(4, 3, 1 * baseEdgeWeight)
        );

        // total number of nodes in the graph
        final int N = 5;

        // build a graph from the given edges
        Graph graph = new Graph(3 * N);
        graph.createEdgesSpecialCase(edges, baseEdgeWeight, N);

        // given the source and destination vertex
        int source = 0, dest = 2;

        boolean[] discovered = new boolean[3 * N];
        int[] path = new int[3 * N];
        Arrays.fill(path, -1);

        // Perform BFS traversal from the given source
        Test31FindShortestPathBetweenTwoVertices.isConnected(graph, source, dest, discovered, path);
        int cost = printPath(path, 2, -1, N);
        System.out.print(" having cost " + cost);
    }

    private static int printPath(int[] predecessor, int vertex, int cost, int N)
    {
        if (vertex == -1 || predecessor[vertex] == -1)
        {
            System.out.print(vertex + " ");
            return 0;
        }

        cost = printPath(predecessor, predecessor[vertex], cost, N);
        cost++;

        // only consider the original nodes present in the graph
        if (vertex < N)
        {
            System.out.print(vertex + " ");
        }

        return cost;
    }

}
