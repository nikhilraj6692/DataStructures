package preparation.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import preparation.util.Edge;
import preparation.util.Graph;
import preparation.util.Pair;

public class Test11CheckIfGraphContainsACycle
{

    public static void main(String[] args)
    {
        List<Edge<Integer>> edges = Arrays.asList(
            new Edge(1, 2), new Edge(3, 1)
            // edge `6 —> 10` introduces a cycle in the graph
        );

        // total number of nodes in the graph
        final int N = 13;
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraphUndirectedGraph(edges);

        /*
        to check if the graph contains cycle, the only check is that if a vertex is already
        visited and its parent is not the
        adjacent node of the visited vertex, then it contains a cycle
         */
        boolean[] visited = new boolean[N];
        boolean isCycleDetected = false;
        for (int i = 0; i < N; i++)
        {
            if (!visited[i])
            {
                if (detectCycle(graph, visited, i, -1))
                {
                    isCycleDetected = true;
                    break;
                }
            }
        }

        if (isCycleDetected)
        {
            System.out.print("It contains a cycle");
        } else
        {
            System.out.print("It does not contain a cycle");
        }

        System.out.print("\n-------------------------------------\n");
        visited = new boolean[N];
        isCycleDetected = false;

        for (int i = 0; i < N; i++)
        {
            if (!visited[i])
            {
                if (detectCycleBFS(graph, visited, i, -1))
                {
                    isCycleDetected = true;
                    break;
                }
            }
        }

        if (isCycleDetected)
        {
            System.out.print("It contains a cycle");
        } else
        {
            System.out.print("It does not contain a cycle");
        }
    }

    private static boolean detectCycleBFS(Graph graph, boolean[] visited, int src, int parent)
    {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(Pair.of(src, parent));
        visited[src] = true;

        while (!q.isEmpty())
        {
            Pair<Integer, Integer> pair = q.poll();
            for (int dest : graph.adjList.get(pair.first))
            {
                if (!visited[dest])
                {
                    visited[dest] = true;
                    q.add(Pair.of(dest, pair.first));
                } else
                {
                    if (dest != pair.second)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean detectCycle(Graph graph, boolean[] visited, int src, int parent)
    {
        visited[src] = true;
        boolean cycleExists = false;

        for (int dest : graph.adjList.get(src))
        {
            if (!visited[dest])
            {
                cycleExists = detectCycle(graph, visited, dest, src);
                if (cycleExists)
                {
                    return true;
                }
            } else
            {
                //check if the destination vertex is having an ancestor as parent
                if (dest != parent)
                {
                    return true;
                }
            }
        }
        return cycleExists;
    }
}
