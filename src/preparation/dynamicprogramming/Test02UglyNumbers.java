package preparation.dynamicprogramming;

import java.awt.event.MouseAdapter;
import java.util.HashSet;
import java.util.Set;

/*
To check if a number is ugly, divide the number by greatest divisible powers of 2, 3 and 5, if the number
becomes 1 then it is an ugly number otherwise not.
 */
public class Test02UglyNumbers {
    public static void main(String[] args) {
        int no = getNthUglyNo(150);

        // Function call
        System.out.println("150th ugly "
                + "no. is " + no);

        //dynamic programming method
        /*
        initialize
       ugly[] =  | 1 |
       i2 =  i3 = i5 = 0;

        First iteration
           ugly[1] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                    = Min(2, 3, 5)
                    = 2
           ugly[] =  | 1 | 2 |
           i2 = 1,  i3 = i5 = 0  (i2 got incremented )

        Second iteration
            ugly[2] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                     = Min(4, 3, 5)
                     = 3
            ugly[] =  | 1 | 2 | 3 |
            i2 = 1,  i3 =  1, i5 = 0  (i3 got incremented )

        Third iteration
            ugly[3] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                     = Min(4, 6, 5)
                     = 4
            ugly[] =  | 1 | 2 | 3 |  4 |
            i2 = 2,  i3 =  1, i5 = 0  (i2 got incremented )

        Fourth iteration
            ugly[4] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                      = Min(6, 6, 5)
                      = 5
            ugly[] =  | 1 | 2 | 3 |  4 | 5 |
            i2 = 2,  i3 =  1, i5 = 1  (i5 got incremented )

        Fifth iteration
            ugly[4] = Min(ugly[i2]*2, ugly[i3]*3, ugly[i5]*5)
                      = Min(6, 6, 10)
                      = 6
            ugly[] =  | 1 | 2 | 3 |  4 | 5 | 6 |
            i2 = 3,  i3 =  2, i5 = 1  (i2 and i3 got incremented )

        Will continue same way till I < 150
         */
        no = getNthNoByDP(150);
        System.out.println("150th ugly "
                + "no. is " + no);
    }

    private static int getNthNoByDP(int num) {
        int two, three, five;
        two = three = five = 0;

        int[] ugly = new int[num];
        ugly[0] = 1;

        int nextMultiple2 = 2;
        int nextMultiple3 = 3;
        int nextMultiple5 = 5;

        int min = Integer.MIN_VALUE;

        int count = 1;
        while(count < num){
            min = Math.min(nextMultiple2, Math.min(nextMultiple3, nextMultiple5));
            ugly[count] = min;

            //if minimum is of 2, then next number should be 2*whatever previous number was there
            if(min == nextMultiple2){
                two++;
                nextMultiple2 = ugly[two] * 2;
            }
            if(min == nextMultiple3){
                three++;
                nextMultiple3 = ugly[three] * 3;
            }
            if(min == nextMultiple5){
                five++;
                nextMultiple5 = ugly[five] * 5;
            }

            count++;
        }

        return min;
    }

    private static int getNthUglyNo(int n) {
        int count = 0;
        int num = 1;
        while(count < n){
            int num1 = num;
            num1 = factorizeWith2(num1, 2);
            num1 = factorizeWith2(num1, 3);
            num1 = factorizeWith2(num1, 5);

            if(num1 == 1 && count == 149){
                return num;
            }else if(num1 == 1){
                count++;
            }

            num++;
        }

        return count;
    }

    private static int factorizeWith2(int num, int fact) {
        while(num%fact == 0){
            num = num/fact;
        }

        return num;
    }
}
