package preparation.util;

public class Edge<Integer>
{

    public int source;
    public int destination;
    public int weight;

    public Edge(int source, int destination, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Edge(int source, int destination)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Edge{" +
            "source=" + source +
            ", destination=" + destination +
            ", weight=" + weight +
            '}';
    }
}
