package preparation.stack;

import java.util.HashMap;
import java.util.HashSet;
import preparation.util.Pair;

import java.util.Stack;

/*
in this algo we have to find most max to left and right of a given element and then find min of both-arr[i] and find sum of all
such outputs
 */
public class Test10RainWaterTrappingProblem {

    private static class A{

    }
    public static void main(String[] args) {
        HashMap m = new HashMap();
        Object o1= new Object();
        Object o2 = o1;
        m.put(o1,1);
        m.put(o2,2);

        System.out.println(m.get(o1));

        HashSet s = new HashSet();
        s.add(new Integer(1));
        s.add(new Integer(1));
        s.add(new Integer(2));
        System.out.println(s.size());

        int[] arr = { 0, 1, 0, 2, 1, 0,
                1, 3, 2, 1, 2, 1 };
        int n = arr.length;

        System.out.print(maxWater(arr,n));
    }

    private static int maxWater(int[] arr, int n) {
        int[] left = new int[n];
        int[] right = new int[n];

        findMaxToRight(left, arr, n);
        findMaxToLeft(right, arr, n);

        int sum = 0;
        for(int i=0;i<n;i++){
            sum+= Math.min(left[i],right[i])-arr[i];
        }

        return sum;
    }

    private static void findMaxToLeft(int[] right, int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            max = Math.max(arr[i], max);
            right[i] = max;
        }
    }

    private static void findMaxToRight(int[] left, int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(arr[i], max);
            left[i] = max;
        }
    }

}
