package preparation.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/*
	- You are given a string that may or may not contain repeating characters.
	- Your task is to find out the length of the longest substring of this given string that does
	not contain any repeating characters.

*/

public class solution
{

    public static void main(String[] args)
    {
        System.out.print(longestSubstringLength("ibnoffjytr"));
    }

    public static int longestSubstringLength(String str)
    {

        //write your code here

        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = str.length();
        int max = 0;

        while (j < n)
        {
            int val = 0;
            if (map.containsKey(str.charAt(j)))
            {
                val = map.get(str.charAt(j));

                map.put(str.charAt(j), ++val);
            } else
            {
                map.put(str.charAt(j), ++val);
            }

            if (val == 1)
            {
                j++;
            } else
            {
                int length = j - i;
                if (length > max)
                {
                    max = length;
                }

                map.clear();
                //also do i = j and j++;
                i = j;
                j++;
            }


        }

        return max;
    }
}
