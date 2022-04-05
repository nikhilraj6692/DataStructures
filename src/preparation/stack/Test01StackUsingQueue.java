package preparation.stack;


import java.util.ArrayDeque;
import java.util.Queue;

public class Test01StackUsingQueue
{

    public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4, 5};
        // insert the above keys into the stack
        Stack2<Integer> s = new Stack2<Integer>();
        for (int key : keys)
        {
            System.out.println("Added element : " + key);
            s.add(key);
        }

        for (int i = 0; i < keys.length; i++)
        {
            System.out.println("Removed element : " + s.poll());
        }
        System.out.println("==========================");
        keys = new int[]{1, 2, 3, 4, 5};
        // insert the above keys into the stack
        Stack1<Integer> s1 = new Stack1<Integer>();
        for (int key : keys)
        {
            System.out.println("Added element : " + key);
            s1.add(key);
        }

        for (int i = 0; i <= keys.length; i++)
        {
            System.out.println("Removed element : " + s1.poll());
        }
    }
}

//implement using two queues...add all elements to second queue before adding a new element. This
// makes adding costlier
//in other case, pop operation can be made costlier also by adding all elements to second queue
// before removing element
class Stack2<T>
{

    private Queue<T> q1, q2;

    Stack2()
    {
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }

    public void add(T key)
    {
        while (!q1.isEmpty())
        {
            q2.add(q1.poll());
        }
        q1.add(key);

        while (!q2.isEmpty())
        {
            q1.add(q2.poll());
        }
    }

    public T poll()
    {
        if (q1.isEmpty())
        {
            System.out.println("Underflow!!");
            System.exit(0);
        }

        return q1.poll();
    }
}

//implement stack using recursive queue call...it is itself a stack but an internal stack call
//recursive call is used to just reverse the queue so that the key which was inserted first in
// the queue becomes last to be polled from
class Stack1<T>
{

    private Queue<T> q1;

    Stack1()
    {
        this.q1 = new ArrayDeque<>();
    }


    public void add(T key)
    {
        q1.add(key);
    }

    public T poll()
    {
        if (q1.isEmpty())
        {
            System.out.println("Underflow!!");
            System.exit(0);
        }

        recursiveCall(q1);

        T key = q1.poll();

        recursiveCall(q1);

        return key;
    }

    private void recursiveCall(Queue<T> q1)
    {
        if (q1.size() == 0)
        {
            return;
        }

        T key = q1.poll();

        recursiveCall(q1);

        q1.add(key);

    }
}

