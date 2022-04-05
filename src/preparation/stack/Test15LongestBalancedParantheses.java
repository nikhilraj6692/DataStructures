package preparation.stack;

import java.util.Stack;

public class Test15LongestBalancedParantheses
{

    public static void main(String[] args)
    {
        String str = "((()()";

        // Function call
        System.out.println(findMaxLen(str));
        System.out.println(findMaxLenWithSimpleApproach(str));

        str = "()(()))))";

        // Function call
        System.out.println(findMaxLen(str));
        System.out.println(findMaxLenWithSimpleApproach(str));
    }

    /*
    in this approach, we know that when we move from 0 to n at a particular index i, if closed
    parentheses is more than open ones,
    that means that certainly expression is invalid till that index, so we reinitialize open and
    closed count. however, at any point
    if both count is same, then we calculate the length and find max value. Also do it the
    opposite way from n-1 to 0. This ensures
    that if there is an expression which becomes invalid at any point, then that is definitely
    not a substring and hence we have to
    make both open and count as 0
     */
    private static int findMaxLenWithSimpleApproach(String str)
    {
        int open = 0, closed = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
            {
                open++;
            } else if (str.charAt(i) == ')')
            {
                closed++;
            }

            if (open == closed)
            {
                int len = open + closed;
                max = Math.max(max, len);
            } else if (closed > open)
            {
                open = 0;
                closed = 0;
            }
        }

        open = 0;
        closed = 0;

        for (int i = str.length() - 1; i >= 0; i--)
        {
            if (str.charAt(i) == '(')
            {
                open++;
            } else if (str.charAt(i) == ')')
            {
                closed++;
            }

            if (open == closed)
            {
                int len = open + closed;
                max = Math.max(max, len);
            } else if (open > closed)
            {
                open = 0;
                closed = 0;
            }
        }

        return max;
    }

    /*
    one solution is to find all substrings of the given str and check all the strings produced if
     they are balanced or not.
    if balanced then update the length of string to max if it is greater than max. seond approach
     is to use stack. we have to
    push -1 first to the stack. And iterate from 0 to n-1, if '(' found then push its index to
    stack. if ')' found then, pop
    from stack. if stack is empty then push the index of closing brace to the stack otherwise
    maximize the result with current
    index-top index of the stack.
     */
    private static int findMaxLen(String str)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
            {
                stack.push(i);
            } else
            {
                int index = stack.pop();

                if (stack.isEmpty())
                {
                    stack.push(i);
                } else
                {
                    max = Math.max(max, (i - stack.peek()));
                }
            }
        }

        return max;
    }
}
