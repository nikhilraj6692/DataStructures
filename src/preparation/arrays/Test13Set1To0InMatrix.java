package preparation.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Problem Description

Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column
to 0.
Note: This will be evaluated on the extra memory used. Try to minimize the space and time
complexity.

Input Format:

The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:

Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 1, 1]   ]


Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]



Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]



Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
 */
public class Test13Set1To0InMatrix
{

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        /*
            Solution: we have to make all colIndices to 0 and all rowIndices to 0, meaning that
            if we maintain a set of both and
            then fill arraylist, then it would work fine
         */
        list.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1)));
        list.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
        list.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
        setZeroes(list);
    }

    public static void setZeroes(ArrayList<ArrayList<Integer>> a)
    {
        Set<Integer> rowIndices = new HashSet<>();
        Set<Integer> colIndices = new HashSet<>();

        for (int i = 0; i < a.size(); i++)
        {
            for (int j = 0; j < a.get(0).size(); j++)
            {
                if (a.get(i).get(j) == 0)
                {
                    rowIndices.add(i);
                    colIndices.add(j);
                }
            }
        }

        for (int i = 0; i < a.size(); i++)
        {
            for (int j = 0; j < a.get(0).size(); j++)
            {
                if (rowIndices.contains(i) || colIndices.contains(j))
                {
                    a.get(i).set(j, 0);
                }
            }
        }

    }


}
