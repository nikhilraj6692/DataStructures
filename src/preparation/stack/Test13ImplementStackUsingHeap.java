package preparation.stack;

import java.util.PriorityQueue;
import preparation.util.Pair;

/*
we are using priority queue to set priority of the last element in the stack as the maximum with
count and reduce count whenever
pop is done. queue is heapified on the basis of max count first
 */
public class Test13ImplementStackUsingHeap
{

    public static void main(String[] args)
    {
        StackE s = new StackE();
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(1);
        s.pop();
        s.pop();
        s.peek();
    }
}

class StackE
{

    int count = 0;
    PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(
        (o1, o2) -> o2.second.compareTo(o1.second));

    public void push(int data)
    {
        q.add(Pair.of(data, ++count));
    }


    public void pop()
    {
        if (q.isEmpty())
        {
            System.out.println("-1");
        } else
        {
            System.out.println(q.poll().first);
            count--;
        }
    }

    public void peek()
    {
        if (q.isEmpty())
        {
            System.out.println("-1");
        } else
        {
            System.out.println(q.peek().first);
        }
    }
}

