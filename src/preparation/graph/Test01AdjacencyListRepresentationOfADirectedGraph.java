package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.*;

public class Test01AdjacencyListRepresentationOfADirectedGraph {

    public static void main(String[] args) {
        //create edges
        List<Edge<Integer>> edges = Arrays.asList(new Edge<>(0, 1), new Edge<>(1, 2),
                new Edge<>(2, 0), new Edge<>(2, 1), new Edge<>(3, 2),
                new Edge<>(4, 5), new Edge<>(5, 4));

        //initializeGraph
        Graph graph = new Graph(5);

        //add edges to graph
        graph.addEdgeToNonWeightedGraph(edges);

        //print adjacency list
        graph.printAdjList();
    }


}
