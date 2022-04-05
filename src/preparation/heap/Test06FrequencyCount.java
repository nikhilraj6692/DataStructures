package preparation.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import preparation.util.Pair;

public class Test06FrequencyCount
{

    public static void main(String[] args)
    {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
        sortBasedOnFrequencyAndValue(arr);
    }

    /*
    one way is to create a map and then sort on the values...now iteratively based on the number
    of count print the element as many
    times as count is, i.e. 8,8,8,2,2,5,5,8. It can be solved via maxheap like previous problem
     */
    private static void sortBasedOnFrequencyAndValue(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //it will compare in decreasing order
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(
            (o1, o2) -> o2.second - o1.second);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            q.add(Pair.of(entry.getKey(), entry.getValue()));
        }

        while (!q.isEmpty())
        {
            Pair<Integer, Integer> pair = q.poll();
            System.out.print(
                String.join(" ", Collections.nCopies(pair.second, String.valueOf(pair.first)))
                    + " ");
        }
    }
}
