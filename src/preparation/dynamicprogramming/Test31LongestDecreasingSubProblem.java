package preparation.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//same as previous one...just we have to do opposite traversal and opposite check
public class Test31LongestDecreasingSubProblem
{

    public static void main(String[] args)
    {
        int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        System.out.println("The length of the LDS is " +
            LDS(A, A.length));

        System.out.print("\n========================================\n");
        printAllLDS(A);
    }

    private static void printAllLDS(int[] a)
    {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
        {
            list.add(i, new ArrayList<>());
        }

        list.get(0).add(a[0]);

        for (int i = 1; i < a.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (a[j] > a[i] && list.get(j).size() > list.get(i).size())
                {
                    list.set(i, new ArrayList<>(list.get(j)));
                }
            }

            list.get(i).add(a[i]);
            System.out.println("LDS[" + i + "] — " + list.get(i));
        }

        //finding out the maximum size list index
        int max = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (list.get(max).size() < list.get(i).size())
            {
                max = i;
            }
        }

        // print max LIS
        System.out.print(list.get(max));


    }

    private static int LDS(int[] a, int length)
    {
        int[] lds = new int[length];
        Arrays.fill(lds, 1);
        for (int i = 1; i < a.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (a[j] > a[i] && lds[i] < lds[j] + 1)
                {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++)
        {
            max = Math.max(max, lds[i]);
        }
        return max;
    }
}
