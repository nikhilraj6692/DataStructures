package preparation.slidingwindow;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test04MaximumInEachWindowOfSizeN
{

    public static void main(String[] args)
    {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        printKMax(arr, arr.length, k);

        System.out.print("\n=======================\n");
        printMaxUsingDeque(arr, arr.length, k);
    }

    private static void printMaxUsingDeque(int[] arr, int length, int k)
    {
        int i = 0, j = 0;
        Deque<Integer> q = new LinkedList<>();

        while (j < length)
        {
            //remove from the end till arr[j]>=q elements
            while (!q.isEmpty() && arr[j] >= q.peekLast())
            {
                q.pollLast();
            }
            q.addLast(arr[j]);

            if (j - i + 1 < k)
            {
                j++;
            } else if (j - i + 1 == k)
            {
                if (!q.isEmpty())
                {
                    //print first element...it will be max only because of above while loop
                    System.out.print(q.peekFirst() + " ");

                    //remove if out of the window
                    if (q.peekFirst() == arr[i])
                    {
                        q.pollFirst();
                    }

                    i++;
                    j++;
                }
            }

        }
    }

    private static void printKMax(int[] arr, int length, int k)
    {
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        int j = 0;

        while (j < length)
        {
            q.add(arr[j]);

            if (j - i + 1 < k)
            {
                j++;
            } else if (j - i + 1 == k)
            {
                if (!q.isEmpty())
                {
                    System.out.print(q.peek() + " ");
                }

                while (!q.isEmpty() && arr[i] == q.peek())
                {
                    q.poll();
                }

                i++;
                j++;
            }
        }
    }
}
