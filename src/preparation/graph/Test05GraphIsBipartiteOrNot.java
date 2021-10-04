package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test05GraphIsBipartiteOrNot {
    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge(1, 2), new Edge(2, 3), new Edge(2, 8),
                new Edge(3, 4), new Edge(4, 6), new Edge(5, 7),
                new Edge(5, 9), new Edge(8, 9), new Edge(2, 4),
                new Edge(2, 10)
                // if we remove `2 —> 4` edge, the graph becomes bipartite
        );

        // total number of nodes in the graph
        final int N = 11;

        //build graph
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);

        /*A graph is a bipartite graph if the node to be visited has adjacent node of a different colour. Here in this graph,
         while doing DFS traversal 2 is a visited node which was assigned a color, lets say false and 4 is also visited which
        was a assigned a colour as false. But while visiting edge (2,4) both are of same colour, so this is not a bipartite graph
        There is one more condition that the graph cannot contain an odd cycle. For odd cycles, check for level of destination and
        src. Both dest and src level should not be the same.*/
        boolean[] visited = new boolean[N];
        boolean[] colorable = new boolean[N];
        int[] level = new int[N];

        if(is2Colorable(graph, visited, colorable, 1) && hasNoOddCycles(graph, 1, N)){
            System.out.print("The graph is bipartite");
        }else{
            System.out.print("The graph is not bipartite");
        }

    }

    private static boolean hasNoOddCycles(Graph graph, int src,  int N) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        int[] level = new int[N];

        q.add(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int vertex = q.poll();

            for(int dest : graph.adjList.get(vertex)){
                q.add(dest);
                if(!visited[dest]){
                    visited[dest] = true;
                    level[dest] = level[vertex] + 1;
                }else{
                    if(level[dest] == level[vertex]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean is2Colorable(Graph graph, boolean[] visited, boolean[] colorable, int src) {
        visited[src] = true;
        boolean val = true;

        for(int dest : graph.adjList.get(src)){
            if(!visited[dest]){
                colorable[dest] = !colorable[src];
                val = is2Colorable(graph, visited, colorable, dest);
                System.out.println(src+ " " + dest);
            }else{
                if(colorable[src] == colorable[dest])
                    return false;
            }
        }

        return val;
    }
}
