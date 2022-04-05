package preparation.util;

import java.util.Objects;

public class Node<T>
{

    public T data;
    public Node<T> left;
    public Node<T> right;
    public int hd;
    public boolean visited;
    public Node<T> next;
    public T step;

    public Node(T data, T step)
    {
        this.data = data;
        this.step = step;
    }

    public Node(T data, Node<T> left, Node<T> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    public Node(T data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
        this.hd = 0;
        this.visited = false;
        this.next = null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(data);
    }

    @Override
    public String toString()
    {
        return "Node{" +
            "data=" + data +
            '}';
    }
}
