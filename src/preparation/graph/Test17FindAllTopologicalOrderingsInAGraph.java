package preparation.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import preparation.util.Edge;
import preparation.util.Graph;

public class Test17FindAllTopologicalOrderingsInAGraph
{

    public static void main(String[] args)
    {
        List<Edge<Integer>> edges = Arrays.asList(
            new Edge(0, 6), new Edge(1, 2),
            new Edge(1, 4), new Edge(1, 6),
            new Edge(3, 0), new Edge(3, 4),
            new Edge(5, 1), new Edge(7, 0),
            new Edge(7, 1)
        );

        // total number of nodes in the graph
        int N = 8;

        // build a graph from the given edges
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);

        /*
        to find all topological orderings, we will do recursive traversal of the method and for
        each and every vertex.
        Complex and same as string permutations
         */
        int[] indegree = new int[N];

        for (int i = 0; i < N; i++)
        {
            for (int dest : graph.adjList.get(i))
            {
                indegree[dest]++;
            }
        }

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[N];

        findAllTopologicalOrderings(graph, indegree, stack, N, visited);
    }

    /*
    using Kahn algorithm over here and finding sorted path if stack length is equal to N
     */
    private static void findAllTopologicalOrderings(Graph graph, int[] indegree,
        Stack<Integer> path, int n, boolean[] visited)
    {
        for (int i = 0; i < n; i++)
        {
            /*
            as we pick only indegree==0 adn not visited in kahn algorithm
             */
            if (indegree[i] == 0 && !visited[i])
            {
                /*
                decrement adjacent vertex of i so as to pick them up in the next iteration
                 */
                for (int dest : graph.adjList.get(i))
                {
                    indegree[dest]--;
                }

                /*
                add vertex to stack and mark it visited
                 */
                path.add(i);
                visited[i] = true;

                /*
                call method recursively so as to find all the combinations
                 */
                findAllTopologicalOrderings(graph, indegree, path, n, visited);

                /*
                reverse changed parameters so that it is picked up again for the next vertex
                (topmost iteration)
                 */
                visited[i] = false;
                path.pop();
                for (int dest : graph.adjList.get(i))
                {
                    indegree[dest]++;
                }
            }
        }

        if (path.size() == n)
        {
            System.out.println(path);
        }
    }
}
