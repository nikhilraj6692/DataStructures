package preparation.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import preparation.util.Edge;
import preparation.util.GNode;
import preparation.util.Graph;

/*
can only handle positive weights
 */
public class Test09DijktraAlgorthm_ShortestPathAlgorithm
{

    public static void main(String[] args)
    {
        // initialize edges as per the above diagram
        // `(u, v, w)` triplet represent undirected edge from
        // vertex `u` to vertex `v` having weight `w`
        List<Edge<Integer>> edges = Arrays.asList(
            new Edge(0, 1, 10), new Edge(0, 4, 3),
            new Edge(1, 2, 2), new Edge(1, 4, 4),
            new Edge(2, 3, 9), new Edge(3, 2, 7),
            new Edge(4, 1, 1), new Edge(4, 2, 8),
            new Edge(4, 3, 2)
        );

        // total number of nodes in the graph
        final int N = 5;
        Graph graph = new Graph(N);
        graph.addEdgeToWeightedGraph(edges);

        /*
         In this algorithm, start from src and update its distance to 0 in a distance array.
         Initialize remaining element to max
         number.The distance array holds the distance of each and every vertex from source node.
         Check for adjacent vertices of the
         visiting vertex and update the adjacent vertex distance (minimum) in case the vertex is
         still not visited. To find out which
         vertex to chose from set of adjacent vertices, use minheap or min,minIndex variables. Do
          this until the queue is empty or
         min heap is empty in case it is solved by min heap. Print out the distance array to get
         the minimum cost of visiting each
         vertex from source vertex. To find out the parent of a vertex recursively from source,
         maintain a prevArray which will
         hold its parent vertex
         */
        performDijktraAlgorithm(graph, N, 0);

        System.out.print("\n-------------------------------------------------------\n");
        performDijktraAlgorithmWithMinHeap(graph, N, 0);
    }

    private static void performDijktraAlgorithmWithMinHeap(Graph graph, int n, int src)
    {
        boolean[] shortestPathArray = new boolean[n];
        shortestPathArray[src] = true;

        int[] prevArray = new int[n];
        prevArray[src] = -1;

        int[] distanceArray = new int[n];
        Arrays.fill(distanceArray, Integer.MAX_VALUE);
        distanceArray[src] = 0;

        /*
        priority queue automatically sorts the values on the basis of comparator provided in it.
        it will contain vertex and its
        distance and the vertices would be sorted on the basis of its distance
         */
        PriorityQueue<GNode> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(node -> node.weight));
        minHeap.add(new GNode(src, 0));

        while (!minHeap.isEmpty())
        {
            GNode node = minHeap.poll();
            int source = node.dest;

            for (GNode vNode : graph.adjWeightedList.get(source))
            {
                int distance = distanceArray[source] + vNode.weight;
                if (!shortestPathArray[vNode.dest] && distance < distanceArray[vNode.dest])
                {
                    distanceArray[vNode.dest] = distance;
                    prevArray[vNode.dest] = source;
                    minHeap.add(new GNode(vNode.dest, distance));
                }
            }

            shortestPathArray[source] = true;
        }

        //print distance array
        System.out.println("Vertex \t Distance from Source \t Path");
        for (int i = 0; i < distanceArray.length; i++)
        {
            System.out.println(
                i + "\t\t\t" + distanceArray[i] + "\t\t\t\t\t " + findPathUtil(prevArray, i, src));
        }

    }


    private static void performDijktraAlgorithm(Graph graph, int n, int src)
    {
        boolean[] shortestPathArray = new boolean[n];
        shortestPathArray[src] = true;

        int[] distanceArray = new int[n];
        Arrays.fill(distanceArray, Integer.MAX_VALUE);
        distanceArray[src] = 0;

        int[] prevArray = new int[n];
        prevArray[src] = -1;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty())
        {
            int vertex = q.poll();
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (GNode node : graph.adjWeightedList.get(vertex))
            {
                int distanceDest = distanceArray[vertex] + node.weight;
                if (!shortestPathArray[node.dest])
                {
                    if (distanceDest < distanceArray[node.dest])
                    {
                        distanceArray[node.dest] = distanceDest;
                        prevArray[node.dest] = vertex;
                    }

                    if (distanceDest < min)
                    {
                        min = distanceDest;
                        minIndex = node.dest;
                    }

                }
            }

            if (minIndex == -1)
            {
                break;
            }

            shortestPathArray[minIndex] = true;
            q.add(minIndex);
        }

        //print distance array
        System.out.println("Vertex \t Distance from Source \t Path");
        for (int i = 0; i < distanceArray.length; i++)
        {
            System.out.println(
                i + "\t\t\t" + distanceArray[i] + "\t\t\t\t\t " + findPathUtil(prevArray, i, src));
        }
    }

    private static String findPathUtil(int[] prevArray, int vertex, int src)
    {
        Stack<Integer> stack = new Stack<>();
        findPath(prevArray, vertex, stack);

        StringBuilder builder = new StringBuilder();
        builder.append(src);
        while (!stack.isEmpty())
        {
            builder.append("->").append(stack.pop());
        }

        return builder.toString();
    }

    private static void findPath(int[] prevArray, int src, Stack<Integer> stack)
    {
        if (prevArray[src] == -1)
        {
            return;
        }

        stack.push(src);
        findPath(prevArray, prevArray[src], stack);
    }
}
