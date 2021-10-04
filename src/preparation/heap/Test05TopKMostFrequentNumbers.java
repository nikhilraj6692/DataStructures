package preparation.heap;

import preparation.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test05TopKMostFrequentNumbers {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 4, 5, 2, 6, 3, 3 };
        int n = arr.length;
        int k = 2;

        // Function call
        print_N_mostFrequentNumber(arr, n, k);

        /*
        another way to do is to have a map of frequent words and sort map on the basis of values in decreasing order of their
        frequency and take k topmost elements. You can sort with
        List list = new LinkedList(map.entrySet());
        //Custom Comparator
        Collections.sort(list, new Comparator()
        {
        public int compare(Object o1, Object o2)
        {
        return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
        }
        });
         */
    }

    /*
    same as closest numbers. difference is that here we will have second element as frequency. create a min heap as we have to
    retain topmost elements. in a min heap, largest elements stay at the bottom
     */
    private static void print_N_mostFrequentNumber(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparing(o -> o.second));

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            q.add(Pair.of(entry.getKey(), entry.getValue()));

            if(q.size() > k){
                q.poll();
            }
        }

        while(!q.isEmpty()){
            System.out.print(q.poll().first + " ");
        }
    }
}
