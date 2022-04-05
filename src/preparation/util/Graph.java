package preparation.util;

import java.util.ArrayList;
import java.util.List;

public class Graph
{

    public List<List<Integer>> adjList = new ArrayList<>();
    public List<List<GNode>> adjWeightedList = new ArrayList<>();
    //Map<Integer, List<Integer>> adjMap = new LinkedHashMap<>();
    //Map<Integer, List<GNode>> adjWeightedMap = new LinkedHashMap<>();

    public Graph(int n)
    {
        //create a list for each of the point till n and each point in the list should be
        // pointing to a linked list,
        //either use a map<integer, list<integer> or list<list<Integer>>. Both are declared above.
        for (int i = 0; i <= n; i++)
        {
            adjList.add(i, new ArrayList<>());
            adjWeightedList.add(i, new ArrayList<>());
            //adjMap.put(i, new ArrayList<>());
        }
    }

    public void addEdgeToNonWeightedGraph(List<Edge<Integer>> edges)
    {
        //now that the map is created, iterate each edge and check for the source in the map. If
        // exists then append the
        //edge destination in the linked list
        for (Edge<Integer> edge : edges)
        {
            adjList.get(edge.source).add(edge.destination);

            //adjMap.computeIfAbsent(edge.source, k->new ArrayList<>()).add(edge.destination);
        }
    }

    public void addEdgeToNonWeightedGraphUndirectedGraph(List<Edge<Integer>> edges)
    {
        //now that the map is created, iterate each edge and check for the source in the map. If
        // exists then append the
        //edge destination in the linked list
        for (Edge<Integer> edge : edges)
        {
            adjList.get(edge.source).add(edge.destination);

            //for undirected graph
            adjList.get(edge.destination).add(edge.source);

            //adjMap.computeIfAbsent(edge.source, k->new ArrayList<>()).add(edge.destination);
        }
    }

    public void printAdjList()
    {
        for (int i = 0; i < adjList.size(); i++)
        {
            System.out.print(i + "-> ");
            for (Integer dest : this.adjList.get(i))
            {
                System.out.print(dest + "-> ");
            }
            System.out.println("NULL");
        }

        /*adjMap.entrySet().stream().forEach(entry->{
            System.out.print(entry.getKey() + "-> ");
            entry.getValue().stream().forEach(dest -> System.out.print(dest + "-> "));
            System.out.println("NULL");
        });*/
    }

    public void addEdgeToWeightedGraph(List<Edge<Integer>> edges)
    {
        //now that the map is created, iterate each edge and check for the source in the map. If
        // exists then append the
        //node with destination and weight in the linked list
        for (Edge<Integer> edge : edges)
        {
            adjWeightedList.get(edge.source).add(new GNode(edge.destination, edge.weight));

            //for undirected graph
            //adjList.get(edge.destination).add(edge.source);

            //adjWeightedMap.computeIfAbsent(edge.source, k->new ArrayList<>()).add(new GNode
            // (edge.destination, edge.weight));
        }
    }

    public void printAdjListWithWeight()
    {
        for (int i = 0; i < adjWeightedList.size(); i++)
        {
            System.out.print(i + "-> ");
            for (GNode node : this.adjWeightedList.get(i))
            {
                System.out.print(node.toString() + "-> ");
            }
            System.out.println("NULL");
        }

        /*adjWeightedMap.entrySet().stream().forEach(entry->{
            System.out.print(entry.getKey() + "-> ");
            entry.getValue().stream().forEach(node -> System.out.print(node.toString() + "-> "));
            System.out.println("NULL");
        });*/
    }

    public void createEdgesSpecialCase(List<Edge<Integer>> edges, int baseEdgeWeight, int N)
    {
        for (Edge<Integer> edge : edges)
        {
            if (edge.weight == 3 * baseEdgeWeight)
            {
                adjList.get(edge.source).add(edge.source + N);
                adjList.get(edge.source + N).add(edge.source + 2 * N);
                adjList.get(edge.source + 2 * N).add(edge.destination);
            } else if (edge.weight == 2 * baseEdgeWeight)
            {
                adjList.get(edge.source).add(edge.source + N);
                adjList.get(edge.source + N).add(edge.destination);
            } else
            {
                adjList.get(edge.source).add(edge.destination);
            }
        }
    }
}
