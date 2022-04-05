package preparation.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Test14RotateMatrixWithoutUsingExtraSpace
{

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        /*
            Solution: we have to make all colIndices to 0 and all rowIndices to 0, meaning that
            if we maintain a set of both and
            then fill arraylist, then it would work fine
         */
        list.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        list.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        rotate(list);
    }

    public static void rotate(ArrayList<ArrayList<Integer>> a)
    {
        int rowLength = a.size();
        int colLength = a.get(0).size();

        for (int i = rowLength - 1; i >= 0; i--)
        {
            for (int j = 0; j < colLength; j++)
            {
                int val = a.get(j).get(Math.abs(i + 1 - colLength));
                a.get(i).set(j, val);
            }
        }

    }
}
