package preparation.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import preparation.util.Edge;
import preparation.util.Graph;

public class Test08IterativeImplementationOfAGraph
{

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge<Integer>> edges = Arrays.asList(
            new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
            new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
            new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
            new Edge(7, 11), new Edge(7, 12)
            // vertex 0, 13, and 14 are single nodes
        );

        // total number of nodes in the graph
        final int N = 15;
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);

        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++)
        {
            if (!visited[i])
            {
                performBFS(graph, visited, i);
            }
        }

        System.out.print("\n-------------------------------------------------------\n");
        visited = new boolean[N];
        for (int i = 0; i < N; i++)
        {
            if (!visited[i])
            {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                performBFSRecursive(graph, visited, q);
            }
        }
    }

    private static void performBFSRecursive(Graph graph, boolean[] visited, Queue<Integer> q)
    {
        if (!q.isEmpty())
        {
            int vertex = q.poll();
            visited[vertex] = true;
            System.out.print(vertex + " ");
            for (int dest : graph.adjList.get(vertex))
            {
                if (!visited[dest])
                {
                    q.add(dest);
                }
            }
        } else
        {
            return;
        }

        performBFSRecursive(graph, visited, q);

    }

    private static void performBFS(Graph graph, boolean[] visited, int src)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while (!q.isEmpty())
        {
            int vertex = q.poll();
            System.out.print(vertex + " ");
            for (int dest : graph.adjList.get(vertex))
            {
                if (!visited[dest])
                {
                    visited[vertex] = true;
                    q.add(dest);
                }
            }
        }
    }
}
