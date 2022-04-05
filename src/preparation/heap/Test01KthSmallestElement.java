package preparation.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
if k is given and largest/smallest/greatest/top/closest/lowest/nearlysorted asked, then heap may
be applied. if k largest then
minheap and k smallest then maxheap. complexity is nlogk. sorting is simple solution or naive
solution for which time complexity is nlogn. in max heap, top is largest
and in minheap, top is smallest
 */
public class Test01KthSmallestElement
{

    public static void main(String[] args)
    {
        int arr[] = new int[]{12, 3, 5, 7, 19};
        int k = 2;
        System.out.print("K'th smallest element is " + kthSmallest(arr, k));

        System.out.println("\n==============================\n");
        arr = new int[]{12, 3, 5, 7, 19};
        System.out.print("K'th smallest element is " + kthSmallestWithMaxHeap(arr, k));
    }

    /*
    in max heap, largest is at top. So, build a priority queue with largest at the top
     */
    private static int kthSmallestWithMaxHeap(int[] arr, int k)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++)
        {
            q.add(arr[i]);

            if (q.size() > k)
            {
                q.poll();
            }
        }

        return q.peek();
    }

    /*
    sort array and find kth smallest element from the starting
     */
    private static int kthSmallest(int[] arr, int k)
    {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++)
        {
            if (i + 1 == k)
            {
                return arr[i];
            }
        }
        return Integer.MAX_VALUE;
    }
}
