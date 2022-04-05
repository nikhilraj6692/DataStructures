package preparation.dynamicprogramming;

public class Test38MinimumNumberOfAdjacentSwapsToConvertIntoPalindrome
{

    public static void main(String[] args)
    {
        String s = "mamad";
        System.out.print(findMinimumNumberOfSwaps(s));
    }

    /*
    the idea is to check for first and last characters of string...if matches then move i to the
    right and j to the
    left. If not matched, then move j to the left till it matches with char at i. once it matches
     with char at i then
     move j to its correct position with the character it matched with character at i. If not
     matched then return
     -1
     */
    private static int findMinimumNumberOfSwaps(String s)
    {
        char[] arr = s.toCharArray();
        int n = arr.length;

        //check for same character...break to find out the index of j at which both characters
        // are same...we have
        //to do this till half of the string as for the string to be palindrome, we have to move
        // till half of the
        //string only. not doing equal to n/2 because we have to compare till last element before
        // middle index
        int count = 0;
        for (int i = 0; i < n / 2; i++)
        {
            int left = i, right = n - i - 1;

            while (left < right)
            {
                if (arr[left] == arr[right])
                {
                    break;
                } else
                {
                    right--;
                }
            }

            /*
            swap till i from right side, meaning that i from right side would be n-i from left
            side -1
            ex: for "aabcdd" and i=1, we will have to swap till n-i-1, i.e. 6-1-1=4
            Returning -1 because we have iterated whole string and there is no such character
            which can match
            char at i, so no need to move further
             */

            if (left == right)
            {
                return -1;
            } else
            {
                for (int k = right; k < n - left - 1; k++)
                {
                    //swap j and its right pointer
                    char temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                    count++;
                }
            }
        }

        return count;
    }
}
