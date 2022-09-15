package preparation.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given a positive integer n and a string s consisting only of letters D or I, you have to find any
 permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]
 */
public class Test10StringPermutation
{

    public static void main(String[] args)
    {
        System.out.print(findPerm("IDDD", 5));
    }

    public static ArrayList<Integer> findPerm(final String A, int B)
    {
        int[] arr = new int[B];
        char[] strArr = A.toCharArray();

        if (strArr.length == 0)
        {
            return new ArrayList<Integer>(Arrays.asList(1));
        } else if (strArr.length == 1)
        {
            if (strArr[0] == 'I')
            {
                return new ArrayList<Integer>(Arrays.asList(1, 2));
            } else
            {
                return new ArrayList<Integer>(Arrays.asList(2, 1));
            }
        }

        arr[0] = 1;
        int maxVal = 1;

        for (int i = 1; i < B; i++)
        {
            if (strArr[i - 1] == 'I')
            {
                arr[i] = maxVal + 1;
                maxVal = arr[i];
            } else
            {
                int nextNum = maxVal + 1;
                int temp = i;

                while (temp > 0 && strArr[temp - 1] != 'I')
                {
                    int currVal = arr[temp - 1];
                    arr[temp - 1] = nextNum;
                    arr[temp] = currVal;
                    temp--;
                }

                maxVal = nextNum;
            }
        }

        ArrayList<Integer> al = new ArrayList<Integer>();

        // Array to ArrayList Conversion
        for (int num : arr)
        {
            al.add(num);
        }
        return al;
    }
}
