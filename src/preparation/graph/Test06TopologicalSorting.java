package preparation.graph;

import preparation.util.Edge;
import preparation.util.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test06TopologicalSorting {
    public static void main(String[] args) {
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );

        final int N = 8;
        Graph graph = new Graph(N);
        graph.addEdgeToNonWeightedGraph(edges);
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];

        for(int i=0;i <N; i++) {
            if(!visited[i])
                performTopologicalSort(graph, visited, stack, i);
        }

        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    /*
    Topological sorting is sorting of vertices in such a way that if there is an edge from u to v, then sorted values ensure
    that u always come before v. The sorted values always begin with a vertex whose in-degree is 0. It differs from DFS in
    such a way that in DFS we print the nodes as soon as we visit the node, whereas in Topological sort, we put all the
    vertices adjacent to a vertex in a stack against each vertex and then print out the stack till stack is empty
     */
    public static void performTopologicalSort(Graph graph, boolean[] visited, Stack<Integer> stack, int src) {
        visited[src] = true;

        for(int dest : graph.adjList.get(src)){
            if(!visited[dest])
                performTopologicalSort(graph, visited, stack, dest);
        }

        stack.push(src);
    }
}
