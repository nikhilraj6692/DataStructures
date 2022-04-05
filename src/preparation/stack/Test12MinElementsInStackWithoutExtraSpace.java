package preparation.stack;

import java.util.Stack;

/*
the algo focusses on using no extra space. for empty stack, push element to the stack and make
min as element. if stack is not
empty and data pushed is greater than min, then DONT update min, just push data in stack. but if
the data to be pushed is
smaller than minimum element, then add corrupted data in the stack as 2*data-min and min becomes
element which was originally to
be pushed. to pop, check if the element in the stack is less than min (corrupted data case), then
 min would be 2*min-corrupteddata,
and val to be popped is min. Same goes for peek.
 */
public class Test12MinElementsInStackWithoutExtraSpace
{

    public static void main(String[] args)
    {
        StackD s = new StackD();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }
}

class StackD
{

    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public StackD()
    {
        this.stack = new Stack<>();
    }

    public void push(int data)
    {
        if (stack.isEmpty())
        {
            min = data;
            stack.push(data);
        } else if (data < min)
        {
            //use the formula 2*data -1 and put the corrupted data in stack
            int corruptedData = 2 * data - min;
            stack.push(corruptedData);

            min = data;
        } else
        {
            stack.push(data);
        }

        System.out.println("Number inserted : " + data);
    }


    public void getMin()
    {
        System.out.println("Minimum Number : " + min);
    }

    public void pop()
    {
        System.out.print("Removed Number : ");
        int val;
        if (stack.isEmpty())
        {
            val = -1;
        } else
        {
            int temp = stack.pop();
            if (temp < min)
            {
                val = min;
                min = 2 * min - temp;
            } else
            {
                val = temp;
            }
        }
        System.out.println(val);
    }

    public void peek()
    {
        System.out.print("Peeked Number : ");
        if (stack.isEmpty())
        {
            System.out.println("-1");
        } else if (stack.peek() < min)
        {
            System.out.println(min);
        } else
        {
            System.out.println(stack.peek());
        }

    }
}
