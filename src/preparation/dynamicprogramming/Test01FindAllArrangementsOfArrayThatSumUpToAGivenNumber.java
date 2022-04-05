package preparation.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Test01FindAllArrangementsOfArrayThatSumUpToAGivenNumber
{

    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 2, 3};
        int n = arr.length;
        int targetSum = 4;
        int sumSoFar = 0;
        List<Integer> list = new ArrayList<>();
        findAllCombinations(arr, n, targetSum, sumSoFar, list);
        System.out.println();
        targetSum = 5;
        sumSoFar = 0;
        list = new ArrayList<>();
        findAllCombinations(1, targetSum, sumSoFar, list);

        System.out.println();
        int sizeSoFar = 0;
        list = new ArrayList<>();
        findAllCombinations(arr, 0, list);
    }

    /*
    classic example of backtracking...always pass index and remove after call is done
     */
    private static void findAllCombinations(int[] arr, int n, int targetSum, int sumSoFar,
        List<Integer> result)
    {
        if (sumSoFar == targetSum)
        {
            result.forEach(elem -> System.out.print(elem + " "));
            System.out.println();
            return;
        } else if (sumSoFar > targetSum)
        {
            return;
        }

        for (int i = 0; i < n && (arr[i] + sumSoFar <= targetSum); i++)
        {
            result.add(arr[i]);
            sumSoFar += arr[i];

            findAllCombinations(arr, n, targetSum, sumSoFar, result);

            result.remove(result.size() - 1);
            sumSoFar -= arr[i];
        }
    }

    private static void findAllCombinations(int num, int targetSum, int sumSoFar,
        List<Integer> result)
    {
        if (sumSoFar == targetSum)
        {
            System.out.print(result.toString());
            return;
        } else if (sumSoFar > targetSum)
        {
            return;
        }

        for (int i = num; ; i = i + 2)
        {
            if (sumSoFar + i <= targetSum)
            {
                result.add(i);
                sumSoFar = sumSoFar + i;

                findAllCombinations(num, targetSum, sumSoFar, result);

                result.remove(result.size() - 1);
                sumSoFar = sumSoFar - i;
            } else
            {
                return;
            }
        }

    }

    private static void findAllCombinations(int[] arr, int index, List<Integer> result)
    {
        if (index == arr.length)
        {
            System.out.print(result.toString());
            return;
        }

        //do not pick element
        findAllCombinations(arr, index + 1, result);

        //pick element
        result.add(arr[index]);
        findAllCombinations(arr, index + 1, result);
        result.remove(result.size() - 1);
    }
}
