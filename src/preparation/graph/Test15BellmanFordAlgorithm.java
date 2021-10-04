package preparation.graph;

import preparation.util.Edge;

import java.util.Arrays;
import java.util.List;

/*
The algorithm can check for shortest path for negative weights, which Dijktra algor cannot. But it does not work for negative
weight cycles. Negative weight cycle means that if in a graph sum of vertices of a cycle results in negative integer, then
shortest path cannot be found
 */
public class Test15BellmanFordAlgorithm {
    public static void main(String[] args) {
        List<Edge<Integer>> edges = Arrays.asList(
                // `(x, y, w)` —> edge from `x` to `y` having weight `w`
                new Edge( 0, 1, -1 ), new Edge( 0, 2, 4 ),
                new Edge( 1, 2, 3 ), new Edge( 1, 3, 2 ),
                new Edge( 1, 4, 2 ), new Edge( 3, 2, 5 ),
                new Edge( 3, 1, 1 ), new Edge( 4, 3, -3 )
        );

        // set the maximum number of nodes in the graph
        final int N = 5;

        // let source be vertex 0
        int source = 0;

        /*
        In this algorithm, the iteration runs for N-1 times. With each iteration, edge in edges list iterates and the distance of
        a vertex v is updated if distance[u] + cost(u,v) is less than distance[v]. By the end of all the iteration of N-1 count,
        we should be able to get shortest path and the cost of reaching each vertex
         */
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        /*
        parent array to maintain parent vertex of each node, so as to print path from any vertex to any other vertex
         */
        int[] parent = new int[N];
        Arrays.fill(parent, -1);

        doBellmanFordAlgorithm(distance, parent, edges, N);
    }

    private static void doBellmanFordAlgorithm(int[] distance, int[] parent, List<Edge<Integer>> edges, int n) {
        for(int i = 0; i< n-1; i++){
            for(Edge<Integer> edge: edges){
                if(distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                    parent[edge.destination] = edge.source;
                }
            }
        }

        /*
        check if there is a negative weight cycle. If after all the iterations, the distance is updated, it means that shortest path
        is not found and there must be a negative weight cycle
         */
        for(Edge<Integer> edge: edges){
            if(distance[edge.source] + edge.weight < distance[edge.destination]) {
                System.out.print("Negative weight cycle found!!!");
                return;
            }
        }

        System.out.println("Vertex\tCost\tPath(From Source)");
        for(int i=0; i<distance.length; i++){
            System.out.println(i + "\t\t" + distance[i] + "\t\t" + findParentUtil(parent, i));
        }
    }

    private static String findParentUtil(int[] parent, int v) {
        StringBuilder pathBuilder = new StringBuilder();
        return findPath(parent, v, pathBuilder).toString();
    }

    private static StringBuilder findPath(int[] parent, int v, StringBuilder pathBuilder) {
        if(parent[v]==-1)
            return pathBuilder.append(v);

        StringBuilder temp = findPath(parent, parent[v], pathBuilder);
        return temp.append("->").append(v);
    }
}
