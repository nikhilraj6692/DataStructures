package preparation.heap;

import preparation.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test07TopKClosestPointToTheOrigin {
    public static void main(String[] args) {
        int points[][] = { { 3, 3 },
                { 5, -1 },
                { -2, 4 } };

        int K = 2;

        pClosest(points, K);
    }

    /*
    closest point to the origin means that Math.sqrt((x2-x1)^2 + (y2-y1)^2), here x2 and y2 is origin ,i.e. 0,0. so the equation
    would be be reduced to Math.sqrt(x2^2+y2^2). Create a a map corresponding to
    array index against the values and the minheap till k values. finally pop the minheap and print key corresponding to the
    equation value from the map and array. another way is to just create map and sort on values of the equation in ascending order
    and then print top k elements
     */
    private static void pClosest(int[][] points, int k) {
        Map<Integer, Double> map = new HashMap<>();

        for(int i=0;i <points.length; i++){
            map.put(i, Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)));
        }

        PriorityQueue<Pair<Integer, Double>> q = new PriorityQueue<>((o1,o2)->o2.second.compareTo(o1.second));
        for(Map.Entry<Integer, Double> entry : map.entrySet()){
            q.add(Pair.of(entry.getKey(), entry.getValue()));

            if(q.size() > k){
                q.poll();
            }
        }

        while(!q.isEmpty()){
            System.out.print("(" + points[q.peek().first][0] + "," + points[q.peek().first][1] + ") ");
            q.poll();
        }

    }
}
