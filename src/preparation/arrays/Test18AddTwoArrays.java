package preparation.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test18AddTwoArrays
{

    public static void main(String[] args)
    {
        ArrayList<Integer> finalList = addArrays(new ArrayList<>(Arrays.asList(3,0,5 )),
            new ArrayList<>(Arrays.asList(3,6)));
        System.out.println(finalList);
    }

    public static ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B)
    {
        ArrayList<Integer> finalList = new ArrayList<>();

        int ALen = A.size()-1;
        int BLen = B.size()-1;

        int carry = 0;
        while (ALen>=0 && BLen>=0)
        {
            int sum = A.get(ALen) + B.get(BLen) + carry;

            if (sum > 9)
            {
                int rem = sum % 10;
                carry = sum / 10;
                finalList.add(rem);
            } else
            {
                finalList.add(sum);
                carry = 0;
            }

            ALen--;
            BLen--;
        }

        if (ALen>=0)
        {
            for (int i = ALen; i >= 0; i--)
            {
                int sum = A.get(i) + carry;

                if (sum > 9)
                {
                    int rem = sum % 10;
                    carry = sum / 10;
                    finalList.add(rem);
                } else
                {
                    finalList.add(sum);
                    carry = 0;
                }
            }
        } else if (BLen>=0)
        {
            for (int i = BLen; i >= 0; i--)
            {
                int sum = B.get(i) + carry;

                if (sum > 9)
                {
                    int rem = sum % 10;
                    carry = sum / 10;
                    finalList.add(rem);
                } else
                {
                    finalList.add(sum);
                    carry = 0;
                }
            }
        }

        if (carry > 0)
        {
            finalList.add(carry);
        }

        Collections.reverse(finalList);

        return finalList;
    }
}
