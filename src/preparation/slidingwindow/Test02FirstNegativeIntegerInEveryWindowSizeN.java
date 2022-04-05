package preparation.slidingwindow;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test02FirstNegativeIntegerInEveryWindowSizeN
{

    public static void main(String[] args)
    {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        printFirstNegativeInteger(arr, n, k);

        System.out.print("\n========================\n");
        printFirstNegativeIntegerUsingQueue(arr, n, k);

        System.out.print("\n========================\n");
        printFirstNegativeIntegerUsingQueueWithSameStructureAsPrevProblem(arr, n, k);
    }

    private static void printFirstNegativeIntegerUsingQueueWithSameStructureAsPrevProblem(int[] arr,
        int n, int k)
    {
        int i = 0, j = 0;
        Queue<Integer> q = new ArrayDeque();

        while (j < n)
        {
            if (arr[j] < 0)
            {
                q.add(arr[j]);
            }

            if (j - i + 1 < k)
            {
                j++;
            } else if (j - i + 1 == k)
            {
                if (!q.isEmpty())
                {
                    System.out.print(q.peek() + " ");
                } else
                {
                    System.out.print(0 + " ");
                }

                if (!q.isEmpty() && q.peek() == arr[i])
                {
                    q.poll();
                }
                i++;
                j++;
            }
        }
    }

    /*
    the idea is to add first k index in the queue for which numbers are negative. Then iterate
    from first k+1th element and print
     element one by one by peeking from the queue if the queue is not empty and then adding to
     the queue if the current index is
      negative. Finally take out the first index from the queue which is outside of the current
      window
     */
    //int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
    // 2 4
    private static void printFirstNegativeIntegerUsingQueue(int[] arr, int n, int k)
    {
        Queue<Integer> q = new ArrayDeque<>();

        //add first k negative number index
        int i;
        for (i = 0; i < k; i++)
        {
            if (arr[i] < 0)
            {
                q.add(i);
            }
        }

        //process remaining elements
        for (int j = i; j < n; j++)
        {
            if (!q.isEmpty())
            {
                System.out.print(arr[q.peek()] + " ");
            } else
            {
                System.out.print(0 + " ");
            }

            if (arr[j] < 0)
            {
                q.add(j);
            }

            //remove elements out of the window
            while (!q.isEmpty() && q.peek() < j - k + 1)
            {
                q.poll();
            }
        }

        //process last window
        if (!q.isEmpty())
        {
            System.out.print(arr[q.poll()]);
        } else
        {
            System.out.print(0 + " ");
        }

    }

    private static void printFirstNegativeInteger(int[] arr, int n, int k)
    {
        for (int i = 0; i <= n - k; i++)
        {
            for (int j = i; j < i + n; )
            {
                if (arr[j] < 0)
                {
                    System.out.print(arr[j] + " ");
                    break;
                }

                if (j < i + k - 1)
                {
                    j++;
                } else if (j == i + k - 1)
                {
                    System.out.print(0);
                    break;
                }
            }
        }
    }
}
