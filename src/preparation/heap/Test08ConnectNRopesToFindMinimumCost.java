package preparation.heap;

import java.util.PriorityQueue;

/*
this question is of heap because at each time, we have to take minimum of the numbers and add
first two numbers. ex:
let the ropes length array be 1,2,3,4,5 then 1+2=3, now top two min be 3,3, add them i.e. 3+3 =6.
 Top two elements are 4 and 5
.Add them, i.e. 4+5=9. Top two elements are 6 and 9 . Add them and ans is 3+6+9+15=33.

O(nLogn), assuming that we use a O(nLogn) sorting algorithm. Note that heap operations like
insert and extract take O(Logn) time.
O(n), The space required to store the values in min heap
 */
public class Test08ConnectNRopesToFindMinimumCost
{

    public static void main(String[] args)
    {
        int len[] = {4, 3, 2, 6};
        int size = len.length;

        System.out.println("Total cost for connecting ropes is " + minCost(len, size));
    }

    private static int minCost(int[] len, int size)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        //created min heap
        for (int i = 0; i < size; i++)
        {
            q.add(len[i]);
        }

        //now iterate and take out first and second top, add them and put in heap so that the sum
        // is placed at the correct position
        int totalCost = 0;
        while (q.size() > 1)
        {
            int first = q.poll();
            int second = q.poll();

            int sum = first + second;
            totalCost += sum;
            q.add(sum);
        }
        return totalCost;

    }
}
