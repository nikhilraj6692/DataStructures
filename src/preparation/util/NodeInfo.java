package preparation.util;

public class NodeInfo
{

    public int key;
    public int level;
    public Node parent = null;

    public NodeInfo(int key, int level, Node parent)
    {
        this.key = key;
        this.level = level;
        this.parent = parent;
    }

}
