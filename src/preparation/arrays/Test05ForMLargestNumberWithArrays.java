package preparation.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test05ForMLargestNumberWithArrays
{

    public static void main(String[] args)
    {
        String largest = solve(new int[]{8, 89});
        System.out.print(largest);
    }

    private static String solve(int[] A)
    {
        Comparator<String> comparator = (o1, o2) -> {
            String first = o1 + o2;
            String second = o2 + o1;

            return second.compareTo(first);
        };

        StringBuilder b = new StringBuilder();
        String[] arr = Arrays.stream(A).boxed().map(String::valueOf).sorted(comparator)
            .toArray(String[]::new);

        int i;
        boolean firstNonZeroFound = false;
        for (String s : arr)
        {
            if (s.equals("0") && firstNonZeroFound)
            {
                b.append(s);
            } else if (!s.equals("0"))
            {
                b.append(s);
                firstNonZeroFound = true;
            }
        }

        if (b.length() == 0)
        {
            return "0";
        }

        return b.toString();
    }
}
