package preparation.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Test06LongestSubstringOfKUniqueCharacters
{

    public static void main(String[] args)
    {
        String s = "aabacbebebe";
        int k = 3;
        kUniques(s, k);
    }

    /*
    same approach as max subarray. Here for condition we will use map and will condition on map
    .size()
     */
    private static void kUniques(String s, int k)
    {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        char[] strArr = s.toCharArray();
        int max = Integer.MIN_VALUE;
        int startIndex = -1, endIndex = -1;

        while (j < strArr.length)
        {
            map.compute(strArr[j], (key, val) -> val == null ? 1 : val + 1);

            if (map.size() < k)
            {
                j++;
            } else if (map.size() == k)
            {
                if (j - i + 1 > max)
                {
                    max = j - i + 1;
                    startIndex = i;
                    endIndex = j;
                }
                j++;
            } else
            {
                //greater than k condition
                while (map.size() > k)
                {
                    int val = map.get(strArr[i]);

                    if (val == 1)
                    {
                        map.remove(strArr[i]);
                    } else
                    {
                        map.put(strArr[i], val - 1);
                    }
                    i++;
                }
                j++;
            }
        }

        System.out.print(s.substring(startIndex, endIndex + 1) + " with length " + max);
    }
}
