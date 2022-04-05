package preparation.arrays;

/*
You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, ..
., AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip
 the characters AL, AL+1, ..., AR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.

If you don't want to perform the operation, return an empty array. Else, return an array
consisting of two elements denoting L and R. If there are multiple solutions, return the
lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.



Input Format
First and only argument is a string A.



Output Format
Return an array of integers denoting the answer.



Example Input
Input 1:

A = "010"
Input 2:

A = "111"


Example Output
Output 1:

[1, 1]
Output 2:

[]


Example Explanation
Explanation 1:

A = "010"


Pair of [L, R] | Final string
____________|__________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"



We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1,
 1].

Explanation 2:

No operation can give us more than three 1s in final string. So, we return empty array [].
 */
public class Test03FlipOne
{

    public static void main(String[] args)
    {
        int[] arr = flip("011");
        for (int val : arr)
        {
            System.out.print(val + " ");
        }

        System.out.println();

        arr = flipOptimized("011100");
        for (int val : arr)
        {
            System.out.print(val + " ");
        }
    }

    /*
    here we are also maintaining counter of 0 and 1. for 0 we will do count++ and for 1 we will
    do count-- so that
    we can discard the array for which count becomes negative like kadane's algorithm. See test01
    . only one thing
    is that we will only update left index when count is less than 0 because we don't want the
    array till that point
    for which count is negative. and if the max array length comes out to be more than what the
    current count is it means
    that we have to update right index also...
     */
    private static int[] flipOptimized(String str)
    {
        char[] arr = str.toCharArray();

        int l = 0, lmax = -1, r = -1, max_ending_here = 0, max_so_far = 0;

        for (int i = 0; i < str.length(); i++)
        {
            if (arr[i] == '0')
            {
                max_ending_here++;
            } else
            {
                max_ending_here--;
            }

            if (max_ending_here > max_so_far)
            {
                max_so_far = max_ending_here;
                r = i;
                lmax = l;
            }

            if (max_ending_here < 0)
            {
                //like kadane's algo
                max_ending_here = 0;
                l = i + 1;
            }
        }

        if (lmax == -1 || r == -1)
        {
            return new int[0];
        } else
        {

            return new int[]{lmax + 1, r + 1};
        }
    }

    /*
    we are doing two loops here...for each i when we iterate j, we check if j is 0 then we don't
    want that 0 and
    we set count to count-1 but for 1, we do count+1. This ensures that we get number of 1's in
    every j flip and
    then compare with max. Also, compare with count because it might be possible that number of 1
     in original array
    is more than what we are getting after flipping at index j...another thing that we are
    reinitializing i each time
    because for each i iteration we have to start checking in original string and not the
    modified string which was
    obtained from previous i and j combo
     */
    public static int[] flip(String A)
    {
        int length = A.length();
        char[] arr = A.toCharArray();
        int max = 0;
        int count = 0;
        int s = -1, e = -1;

        for (int i = 0; i < length; i++)
        {
            if (arr[i] == '1')
            {
                count++;
            }
        }

        int c;
        for (int i = 0; i < length; i++)
        {
            arr = A.toCharArray();
            c = count;
            for (int j = i; j < length; j++)
            {
                if (arr[j] == '0')
                {
                    arr[j] = '1';
                    c++;
                } else
                {
                    arr[j] = '0';
                    c--;
                }
                if (c > max && c > count)
                {
                    s = i + 1;
                    e = j + 1;
                    max = c;
                }
            }
        }

        if (s == -1 && e == -1)
        {
            return new int[0];
        }
        return new int[]{s, e};
    }

}
