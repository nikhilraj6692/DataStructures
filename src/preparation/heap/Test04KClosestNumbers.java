package preparation.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import preparation.util.Pair;

//heapify is always nlogk
public class Test04KClosestNumbers
{

    public static void main(String[] args)
    {
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
            45, 48, 50, 53, 55, 56
        };

        int n = arr.length;
        int x = 35, k = 4;
        printKclosest(arr, x, 4, n);

        /*
        another solution is to do linear traversal and have a treemap so that the values can be
        sorted on value of map and then
        print k elements from the top
         */
    }

    /*
    in this algorithm, we have to find out n numbers which are close to x. So, basically we will
    have to create a max heap of
    differences along with their values...so we can create a pair here and remove the differences
     with priority queue sorted on
    differences in descending order
     */
    private static void printKclosest(int[] arr, int x, int k, int n)
    {
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(
            new Comparator<Pair<Integer, Integer>>()
            {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2)
                {
                    return o2.second.compareTo(o1.second);
                }
            });

        for (int i = 0; i < n; i++)
        {
            q.add(Pair.of(arr[i], Math.abs(x - arr[i])));

            if (q.size() > k)
            {
                q.poll();
            }
        }

        while (!q.isEmpty())
        {
            System.out.print(q.poll().first + " ");
        }
    }
}
