package preparation.util;

public class NodeWrapper<T>
{

    public Node<T> node;

    public NodeWrapper()
    {
    }

    public NodeWrapper(int data)
    {
        this.node = new Node(data);
    }
}