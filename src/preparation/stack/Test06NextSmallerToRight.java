package preparation.stack;

import java.util.Stack;

//same concept as previous
public class Test06NextSmallerToRight
{

    public static void main(String[] args)
    {
        int arr[] = {4, 5, 2, 10, 8};
        int n = arr.length;
        printNextSmaller(arr, n);
    }

    private static void printNextSmaller(int[] arr, int n)
    {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> finalAnswer = new Stack<>();

        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && stack.peek() > arr[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                finalAnswer.push(Integer.MAX_VALUE);
            } else
            {
                finalAnswer.push(stack.peek());
            }

            stack.add(arr[i]);
        }

        while (!finalAnswer.isEmpty())
        {
            int val = finalAnswer.pop();
            if (val != Integer.MAX_VALUE)
            {
                System.out.print(val + " ");
            } else
            {
                System.out.print("MAX" + " ");
            }
        }
    }
}
