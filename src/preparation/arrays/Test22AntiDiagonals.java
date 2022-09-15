package preparation.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Test22AntiDiagonals
{

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        list.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        list.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
        list.add(new ArrayList<>(Arrays.asList(13,14,15,16)));
        for(ArrayList<Integer> inner : list){
            System.out.println(inner);
        }
        System.out.println("-----Anti-Diagonals-----");
        ArrayList<ArrayList<Integer>> finalList = diagonal(list);
        for(ArrayList<Integer> inner : finalList){
            System.out.println(inner);
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A)
    {
        int maxLen = A.size() + (A.size() - 1);

        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();

        for (int i = 0; i < maxLen; i++)
        {
            ArrayList<Integer> innerList = new ArrayList<>();
            if (i < A.size())
            {
                int temp = i;
                for (int j = 0; j <= i; j++)
                {
                    innerList.add(A.get(j).get(temp));
                    temp--;
                }
                outerList.add(innerList);
            } else
            {
                int temp = A.size() - 1;
                for (int j = i - A.size() + 1; j <= A.size() - 1; j++)
                {
                    innerList.add(A.get(j).get(temp));
                    temp--;
                }
                outerList.add(innerList);
            }
        }

        return outerList;
    }


}
