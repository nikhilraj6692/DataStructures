package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.Arrays;
import java.util.List;

public class Test20KColorableGraph {
    public static void main(String[] args) {
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 4),
                new Edge(0, 5), new Edge(4, 5),
                new Edge(1, 4), new Edge(1, 3),
                new Edge(2, 3), new Edge(2, 4)
        );

        // total number of nodes in the graph
        final int N = 6;
        Graph g = new Graph(6);
        g.addEdgeToNonWeightedGraphUndirectedGraph(edges);

        /*
        this is a np problem, so there is exactly not an algo which will give minimum number of colors to color a graph such that
        the adjacent vertices does not have same color. But with this algo, we can target to color vertices greedily. In this algo,
        we will assign one colour to first vertex and then start iterating from second vertex. lets say that the second vertex is
        connected to the first colour assigned vertex, in this case second should be having a different colour than the first. In
         short, if a colour is assigned to an adjacent vertex, then mark the availability of colour (which is a separate array)
        to false. Do it for all adjacent vertices for which colour is already assigned in result array. now, to find the colour
        that should be assignable to the src vertex, iterate color from 0 to n(vertices) colors (colour is distinguished via 0,1,2...)
        and find colour which is available. Finally, assign that colour in result array and again reset available colours so as to
        start from the beginning for next iteration
         */
        greedyColoring(g, N);
    }

    private static void greedyColoring(Graph g, int n) {
        int[] result = new int[n];
        Arrays.fill(result, -1);

        boolean[] availableColors = new boolean[n];
        Arrays.fill(availableColors, true);

        //assign 1st color to first vertex
        result[0] = 0;
        availableColors[result[0]] = false;

        /*
        make available colour to false for the element for which already there is some colour assigned
         */
        for(int v=1; v<n; v++) {
            for (int dest : g.adjList.get(v)) {
                if (result[dest] != -1) {
                    availableColors[result[dest]] = false;
                }
            }


            /*
            find index with available colour
             */
            int cr;
            for (cr = 0; cr < n; cr++) {
                if (availableColors[cr] == true)
                    break;
            }

            /*
            assign color to vertex
             */
            result[v] = cr;

            /*
            main code...reset available colors to true once again because for each vertex adjacent elements will change and hence
            the available colours will also change
             */
            Arrays.fill(availableColors, true);
        }


        for(int i=0; i<result.length; i++){
            if(result[i]!=-1)
                System.out.println(i + " :: Colour " + result[i]);
        }
    }
}
