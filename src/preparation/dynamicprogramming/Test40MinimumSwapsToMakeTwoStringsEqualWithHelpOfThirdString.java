package preparation.dynamicprogramming;

public class Test40MinimumSwapsToMakeTwoStringsEqualWithHelpOfThirdString
{

    /*
    this is a very strange question for which we can only make two strings equal by swapping with
     third string.
    to solve this, we have to check char at a and char at b, if equal then move a and b pointer
    to right...
    however if not equal then check if char at a is equal to char at c or char at b is equal to c
    ...if found any,
    then swap b and c if a is equal and vice versa...if not found equal, then return -1...
    not sure why this is being done
     */
    public static void main(String[] args)
    {
        String a = "xyz";
        String b = "yzx";
        String c = "yzx";

        System.out.print(swapOperations(a.toCharArray(), b.toCharArray(), c.toCharArray()));
    }

    private static int swapOperations(char[] a, char[] b, char[] c)
    {
        int i = 0;
        int n = a.length;

        int count = 0;
        for (i = 0; i < n; i++)
        {
            if (a[i] == b[i])
            {
                continue;
            } else
            {
                if (a[i] == c[i])
                {
                    char temp = b[i];
                    b[i] = c[i];
                    c[i] = temp;
                    count++;
                } else if (b[i] == c[i])
                {
                    char temp = a[i];
                    a[i] = c[i];
                    c[i] = temp;
                    count++;
                } else
                {
                    return -1;
                }
            }
        }

        return count;
    }
}
