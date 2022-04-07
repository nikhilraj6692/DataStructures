package preparation.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test09DifferenceBetweenK1thSmallestAndK2thSmallest
{

    public static void main(String[] args)
    {
        int arr[] = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 3, k2 = 6;
        int n = arr.length;

        System.out.print(sumBetweenTwoKth(arr,
            k1, k2));
    }

    /*
    one way is to sort the array and then find k1st smallest and k2nd smallest and find the sum
    of all numbers between them.
    second way is to either call two functions against both k and get max for both k. then
    traverse the array and check which is
    greater than first k and less than second k and find sum of all those numbers. third way is
    to fill max heap till largest of
    both k and then poll the heap till smallest k is found. below is third way
     */
    private static int sumBetweenTwoKth(int[] arr, int k1, int k2)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int max = Math.max(k1, k2);

        for (int i = 0; i < arr.length; i++)
        {
            q.add(arr[i]);

            if (q.size() > max)
            {
                q.poll();
            }
        }

        //remove first element, as we only want to sum between both k
        q.poll();
        int count = 0;
        int sum = 0;

        //-1 because we have already removed an element
        while (count < (k2 - k1 - 1))
        {
            sum += q.poll();
            count++;
        }

        return sum;
    }
}
