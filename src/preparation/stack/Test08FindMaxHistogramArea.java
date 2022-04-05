package preparation.stack;

import java.util.Stack;
import preparation.util.Pair;

public class Test08FindMaxHistogramArea
{

    public static void main(String[] args)
    {
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("\nMaximum area is " + getMaxArea(hist, hist.length));
    }


    public static int getMaxArea(int[] hist, int length)
    {

        int max = Integer.MIN_VALUE;
        //find next index minimum to the right
        int[] right = new int[length];
        findNextMinimumToTheRight(hist, length, right);

        //find next index minimum to the left
        int[] left = new int[length];
        findNextMinimumToTheLeft(hist, length, left);

        for (int i = 0; i < length; i++)
        {
            int area = hist[i] * (right[i] - left[i] - 1);
            System.out.print(area + " ");
            max = Math.max(max, area);
        }

        return max;
    }

    //{ 6, 2, 5, 4, 5, 1, 6 }
    /*

        1  5  4  5   5   -1 -1
     */
    private static void findNextMinimumToTheRight(int[] hist, int length, int[] right)
    {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && stack.peek().first >= hist[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                right[i] = length;
            } else
            {
                right[i] = stack.peek().second;
            }

            stack.push(Pair.of(hist[i], i));
        }
    }

    private static void findNextMinimumToTheLeft(int[] hist, int length, int[] left)
    {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i < length; i++)
        {
            while (!stack.isEmpty() && stack.peek().first >= hist[i])
            {
                stack.pop();
            }

            if (stack.isEmpty())
            {
                left[i] = -1;
            } else
            {
                left[i] = stack.peek().second;
            }

            stack.push(Pair.of(hist[i], i));
        }
    }
}
