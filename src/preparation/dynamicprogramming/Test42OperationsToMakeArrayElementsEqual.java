package preparation.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test42OperationsToMakeArrayElementsEqual
{

    public static void main(String[] args)
    {
        System.out.println(solve(new ArrayList<>(Arrays.asList(2, 3, 1)), 1));
    }

    public static int solve(ArrayList<Integer> A, int B)
    {
        int max = Integer.MIN_VALUE;

        for (int num : A)
        {
            max = Math.max(max, num);
        }

        Set<Integer> possibleValues = new HashSet<>();
        possibleValues.add(max - B);
        possibleValues.add(max + B);
        possibleValues.add(max);

        for (int num : A)
        {
            if (!possibleValues.contains(num + B) && !possibleValues.contains(num - B)
                && !possibleValues.contains(num))
            {
                return 0;
            }
        }

        return 1;


    }


}
