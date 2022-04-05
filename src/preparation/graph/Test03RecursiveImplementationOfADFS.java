package preparation.graph;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import preparation.util.Edge;
import preparation.util.Graph;

public class Test03RecursiveImplementationOfADFS
{

    public static void main(String[] args)
    {
        List<Edge<Integer>> edges = Arrays.asList(
            // Notice that node 0 is unconnected
            new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
            new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
            new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
            new Edge(9, 10), new Edge(9, 11)
        );

        // total number of nodes in the graph (0–12)
        final int N = 13;

        // build a graph from the given edges
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);
        boolean[] visited = new boolean[N];

        performRecursiveDFS(graph, 1, visited);
        System.out.print("\n---------------------------------\n");
        visited = new boolean[N];
        performNonRecursiveDFS(graph, 1, visited);
    }

    private static void performNonRecursiveDFS(Graph graph, int src, boolean[] visited)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(src);

        while (!stack.isEmpty())
        {
            int vertex = stack.pop();

            //it might be possible that other node is pointing to a vertex which has already been
            // visited, so to take
            //care of this, use visited array
            if (visited[vertex])
            {
                continue;
            }

            System.out.print(vertex + " ");
            List<Integer> dests = graph.adjList.get(vertex);
            for (ListIterator<Integer> it = dests.listIterator(dests.size()); it.hasPrevious(); )
            {
                int dest = it.previous();
                if (!visited[vertex])
                {
                    stack.push(dest);
                }
            }
        }
    }

    public static void performRecursiveDFS(Graph graph, int src, boolean[] visited)
    {
        visited[src] = true;
        System.out.print(src + " ");

        graph.adjList.get(src).stream().forEach(dest -> {
            if (!visited[dest])
            {
                performRecursiveDFS(graph, dest, visited);
            }
        });
    }
}
