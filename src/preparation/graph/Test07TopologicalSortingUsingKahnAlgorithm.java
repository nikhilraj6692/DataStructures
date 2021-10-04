package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.*;

public class Test07TopologicalSortingUsingKahnAlgorithm {
    public static void main(String[] args) {
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );

        // total number of nodes in the graph
        final int N = 8;
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);

        /*
        This algorithm works on indegree of a vertex. The algorithm says that if there is a topological sorting present
        in a graph, then there should be at least one vertex with indegree as 0 and one vertex with outdegree as 0. To
        write the algorithm, create an indegree array and fill it with indegree of each vertex. This can be achieved via
        two ways, one by iterating through each vertex and checking all the destination vertex of that vertex and
        increment the count for each destination. The other method is to use the arraylist of edges above and fill indegree
        array with destination vertices count. After finding indegree, prepare a queue and fill the queue with only those
        vertices for which indegree is zero. While iterating through the queue, check for vertex adjacent vertices and decrement
        adjacent vertex indegree along with checking if indegree of adjacent vertex has become zero. If it comes to zero then add
        to queue and repeat the process till the queue is empty. Also maintain counter and lastly if counter is equal to N,
        if yes then topological sort can be possible otherwise not
         */
        doTopologicalSorting(graph, N, edges);

    }

    private static void doTopologicalSorting(Graph graph, int n, List<Edge<Integer>> edges) {
        int[] indegree = new int[n];
        for(int i=0;i<=7;i++){
            for(int dest: graph.adjList.get(i)){
                indegree[dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] ==0){
                q.add(i);
            }
        }


        int visitedVerticesCnt = 0;

        List<Integer> sortedKeys = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            sortedKeys.add(curr);

            for(int dest : graph.adjList.get(curr)){
                if(--indegree[dest] == 0)
                    q.add(dest);
            }

            visitedVerticesCnt++;
        }

        if(visitedVerticesCnt != n){
            System.out.print("The graph seems to have a cycle. Topological sort not possible!");
            return;
        }

        sortedKeys.stream().forEach(v->System.out.print(v+ " "));

    }
}
