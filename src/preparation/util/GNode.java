package preparation.util;

public class GNode
{

    public int dest;
    public int weight;

    public GNode(int dest, int weight)
    {
        this.dest = dest;
        this.weight = weight;
    }


    @Override
    public String toString()
    {
        return this.dest + "(" + this.weight + ") ";
    }
}
