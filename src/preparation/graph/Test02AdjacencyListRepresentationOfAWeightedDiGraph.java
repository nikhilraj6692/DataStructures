package preparation.graph;

import java.util.Arrays;
import java.util.List;
import preparation.util.Edge;
import preparation.util.Graph;

public class Test02AdjacencyListRepresentationOfAWeightedDiGraph
{

    public static void main(String[] args)
    {
        List<Edge<Integer>> edges = Arrays.asList(new Edge(0, 1, 6), new Edge(1, 2, 7),
            new Edge(2, 0, 5), new Edge(2, 1, 4),
            new Edge(3, 2, 10), new Edge(4, 5, 1),
            new Edge(5, 4, 3));

        Graph graph = new Graph(5);
        graph.addEdgeToWeightedGraph(edges);
        graph.printAdjListWithWeight();
    }
}
