package preparation.list;

import java.util.Iterator;

/*
so far we have covered linked list using node...here also we will implement via node only but
with Iterator...to get
iterator use Iterable and for next() and hasNext() methods, use Iterator
 */
public class Test54LinkedListUsingIterator
{

    public static void main(String[] args)
    {
        CustomList list = new CustomList();
        list.push(1);
        list.push(2);
        list.push(3);
        ListIterator iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next().data + " ");
        }
    }
}

class ListIterator implements Iterator<Node>
{

    private Node node = null;

    public ListIterator(Node head)
    {
        this.node = head;
    }

    @Override
    public boolean hasNext()
    {
        return null != node;
    }

    @Override
    public Node next()
    {
        Node temp = node;
        node = node.next;
        return temp;
    }
}

class CustomList implements Iterable<Node>
{

    private ListIterator iterator;

    private Node first;
    private Node last;

    public CustomList()
    {
        first = last = null;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public <T> void push(T data)
    {
        Node tempo = new Node();
        tempo.data = data;
        tempo.next = null;

        if (first == null)
        {
            tempo.prev = null;
            first = last = tempo;
        } else
        {
            tempo.prev = last;
            last.next = tempo;
            last = tempo;
        }
    }

    @Override
    public ListIterator iterator()
    {
        return new ListIterator(first);
    }
}

