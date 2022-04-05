package preparation.stack;

import java.util.Stack;
import preparation.util.Pair;

/*
this problem says that you have to return the number of elements which is equal to or less than
the number at the given index and
count such smaller number. ex: for 10, ans is 1, for 4 ans is 1, for 5 ans is 2 (4,5).... we have
 to check what is the max range at
which stock spans like in below example, stock spans most between 10 and 120, so if we look
closely it is a problem of
nearest greater to the left. We have to count all the numbers from the number at given index
which are less OR in other words we have
to stop at nearest greatest number. can be solved via brute force also with i=0 and j=i-1 to j>=0
 */
public class Test07StockSpanProblem
{

    public static void main(String[] args)
    {
        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;

        // Fill the span values in array S[]
        calculateSpan(price, n);
    }

    /*
    -1 0 0 -1 -1 4
     */
    private static void calculateSpan(int[] price, int n)
    {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] count = new int[n];

        int max = 0;
        int val = -1;

        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && stack.peek().first < price[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                count[i] = -1;
            } else
            {
                count[i] = stack.peek().second;
            }

            stack.push(Pair.of(price[i], i));
        }

        /*
        find max...now we got the index of largest number to the left so just subtract it from index
         */
        for (int i = 0; i < count.length; i++)
        {
            if (max < (i - count[i]))
            {
                max = i - count[i];
                val = price[i];
            }

        }

        System.out.print(max + " " + val);
    }
}
