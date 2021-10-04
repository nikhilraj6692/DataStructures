package preparation.graph;

import preparation.util.Edge;

import java.util.*;

/*
This algorithm is used to find minimum spanning tree in a graph
 */
public class Test21KruskalAlgorithm {
    public static void main(String[] args) {
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge(0, 1, 7), new Edge(1, 2, 8),
                new Edge(0, 3, 5), new Edge(1, 3, 9),
                new Edge(1, 4, 7), new Edge(2, 4, 5),
                new Edge(3, 4, 15), new Edge(3, 5, 6),
                new Edge(4, 5, 8), new Edge(4, 6, 9),
                new Edge(5, 6, 11)
        );

        // total number of nodes in the graph
        final int N = 7;

        /*
        In this algorithm, sort the edges on the basis of weight and then pick up each edge once, if it does not form a cycle,
        then consider the edge in MST. If the number of vertices is N, then edges in MST will be N-1. Since finding cycle using dfs
        or bfs would be complicated, so we can do it easily via union find algorithm
         */
        doKruskalAlgorithm(edges, N);
    }

    private static void doKruskalAlgorithm(List<Edge<Integer>> edges, int n) {
        //sort edges
        Collections.sort(edges, Comparator.comparing(x->x.weight));

        DisjointSet set = new DisjointSet();
        set.makeSet(n);

        List<Edge<Integer>> resultantMST = new ArrayList<>();
        int e = 0; //track edge

        //since no. of edges would be N-1, so iterate till N-1
        while(resultantMST.size()!=n-1){
            Edge<Integer> edge = edges.get(e++);
            int src = edge.source;
            int dest = edge.destination;

            int x = set.find(src);
            int y = set.find(dest);

            if(x!=y){
                set.union(x, y);
                resultantMST.add(edge);
            }

        }

        //print resultant mst
        for(Edge edge: resultantMST){
            System.out.println(edge.source + " " +edge.destination + " " + edge.weight);
        }
    }
}

class DisjointSetCopy{
    Map<Integer, Integer> map = new HashMap<>();

    public int find(int src) {
        if(map.get(src) == src)
            return src;

        return find(map.get(src));
    }

    public void makeSet(int n) {
        for(int i=0; i<n; i++){
            map.put(i, i);
        }
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        map.put(a, b);
    }
}
