package preparation.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import preparation.util.Edge;
import preparation.util.Graph;

public class Test24EurelianCyleInDirectedGraph
{

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge<Integer>> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
            new Edge(2, 3), new Edge(3, 1), new Edge(1, 4),
            new Edge(4, 3), new Edge(3, 0));

        // total number of nodes in the graph
        int N = 5;

        // build a directed graph from the above edges
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);

        System.out.println(hasEulerianCycle(graph, N) ? "Graph has eurelian cycle"
            : "Graph does not have an eurelian cycle");
    }

    public static boolean hasEulerianCycle(Graph graph, int n)
    {
        /*
        check strongly connected component using kosaraju algorithm. do dfs once, transpose and
        again do dfs if all vertices visited
        in each traversal then strongly connected component
         */
        boolean[] visited = new boolean[n];
        if (checkIfGraphIsConnectedbyKosarajuAlgo(graph, visited, n)
            && checkIfInDegreeEqualToOutDegree(graph, n))
        {
            return true;
        }
        return false;
    }

    private static boolean checkIfInDegreeEqualToOutDegree(Graph graph, int n)
    {
        //calculate in degree
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++)
        {
            for (int dest : graph.adjList.get(i))
            {
                indegree[dest]++;
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (graph.adjList.get(i).size() != indegree[i])
            {
                return false;
            }
        }

        return true;
    }

    private static boolean checkIfGraphIsConnectedbyKosarajuAlgo(Graph graph, boolean[] visited,
        int N)
    {
        //do dfs first time for the vertex which is connected to some edge
        int i;
        for (i = 0; i < N; i++)
        {
            if (graph.adjList.get(i).size() > 0)
            {
                dfs(i, graph, visited);
                break;
            }
        }

        /*
        graph.adjList.get(j).size()>0 not mandatory. only added for test26 class
         */
        for (int j = 0; j < visited.length; j++)
        {
            if (graph.adjList.get(j).size() > 0 && !visited[j])
            {
                return false;
            }
        }

        //reinitialize graph after reversing edges
        graph = transpose(graph, N);

        Arrays.fill(visited, false);
        dfs(i, graph, visited);

         /*
        graph.adjList.get(i).size()>0 not mandatory. only added for test26 class
         */
        for (int j = 0; j < visited.length; j++)
        {
            if (graph.adjList.get(j).size() > 0 && !visited[j])
            {
                return false;
            }
        }

        return true;
    }

    /*
    create link from adjacent vertex to the src vertex with new set of edges in opposite direction
     */
    private static Graph transpose(Graph graph, int size)
    {
        List<Edge<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            for (int dest : graph.adjList.get(i))
            {
                edges.add(new Edge<>(dest, i));
            }
        }

        //initialize graph
        Graph g = new Graph(size);
        g.addEdgeToNonWeightedGraph(edges);
        return g;
    }

    private static void dfs(int src, Graph graph, boolean[] visited)
    {
        visited[src] = true;

        for (int dest : graph.adjList.get(src))
        {
            if (!visited[dest])
            {
                dfs(dest, graph, visited);
            }
        }
    }
}
