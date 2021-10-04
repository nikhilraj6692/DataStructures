package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
whenever the term shortest path comes, always think about BFS. BFS runs in O(E+V) time complexity. BFS can be used if all edges are of
same weight
 */
public class Test31FindShortestPathBetweenTwoVertices {
    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge<Integer>> edges = Arrays.asList(new Edge<>(0, 3), new Edge<>(1, 0),
                new Edge<>(1, 2), new Edge<>(1, 4),
                new Edge<>(2, 7), new Edge<>(3, 4),
                new Edge<>(3, 5), new Edge<>(4, 3),
                new Edge<>(4, 6), new Edge<>(5, 6),
                new Edge<>(6, 7));

        // total number of nodes in the graph (labeled from 0 to `N-1`)
        int N = 8;

        // build a graph from the given edges
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);

        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[N];

        // source and destination vertex
        int src = 0, dest = 7;
        int[] path = new int[N];
        Arrays.fill(path, -1);

        // perform BFS traversal from the source vertex to check the connectivity
        if (isConnected(graph, src, dest, discovered, path))
        {
            System.out.println("A path exists from vertex " + src +
                    " to vertex " + dest);
            //print path
            printPath(dest, path);
        }
        else {
            System.out.println("No path exists between vertices " + src +
                    " and " + dest);
        }
    }

    private static void printPath(int v, int[] path) {
        if(v==-1 || path[v]==-1) {
            System.out.print(v + " ");
            return;
        }

        printPath(path[v], path);
        System.out.print(v + " ");

    }

    public static boolean isConnected(Graph graph, int src, int dest, boolean[] discovered, int[] path) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        discovered[src] = true;

        while(!q.isEmpty()){
            int v = q.poll();

            if(v == dest)
                return true;

            for(int d : graph.adjList.get(v)){
                if(!discovered[d]){
                    discovered[d] = true;
                    q.add(d);
                    path[d] = v;
                }
            }
        }

        return false;
    }
}
