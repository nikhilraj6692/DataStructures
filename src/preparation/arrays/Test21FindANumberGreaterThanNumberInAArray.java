package preparation.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Think from a word perspective first...let's say that we have a word 'roqpe', the next word in the
 dictionary to be formed with all
the letters in this word will be 'rpeoq'. If we closely observe the word, we may see that we have
 to stop on a letter from the right
which is in increasing fashion, like here it is 'o' (we did this because if we encounter a
character which is in increasing fashion
 from the right, then we are sure that there is a character to the right of it which would form a
  word in lexicographical order). Now,
 to the right of 'o' there are two characters which can be lexicographically fit in a dictionary,
  i.e. 'p' and 'q'. So, the
 words can be formed by swapping 'o' with 'p' or 'q', but the closest word would be with the
 letter whose distance from 'o' would be
 minimum. Here the letter is 'p'. So swap them. The word now becomes 'rpqoe'. After finding next
 higher letter i.e. 'p', we can
 then have remaining characters in ascending fashion. So, after reversing sub-part of word after
 'p', the final word becomes 'rpeoq'.
 Same can be done with numbers.
 */
public class Test21FindANumberGreaterThanNumberInAArray
{

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(
            Arrays.asList(444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758,
                675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16,
                158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916,
                247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784,
                708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422,
                363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52));
        List<Integer> finalList = findNextPermutation(list);
        System.out.println(finalList);
    }

    private static List<Integer> findNextPermutation(List<Integer> A)
    {
        int len = A.size();

        //find number in ascending order fashion
        int index = -1;
        for (int i = len - 2; i >= 0; i--)
        {
            if (A.get(i) < A.get(i + 1))
            {
                index = i;
                break;
            }
        }

        if (index == -1)
        {
            Collections.reverse(A);
            return A;
        }

        //find closest number to number at i
        int minDistance = Integer.MAX_VALUE;
        int toSwapIndex = index + 1;
        for (int j = index + 1; j < len; j++)
        {
            if (A.get(j) > A.get(index) && A.get(j) - A.get(index) < minDistance)
            {
                minDistance = A.get(j) - A.get(index);
                toSwapIndex = j;
            }
        }

        //swap index and toSwapIndex
        int temp = A.get(index);
        A.set(index, A.get(toSwapIndex));
        A.set(toSwapIndex, temp);

        //now reverse in ascending order after index+1
        int i = index + 1;
        int j = len - 1;
        while (i < j)
        {
            int num = A.get(i);
            A.set(i, A.get(j));
            A.set(j, num);
            i++;
            j--;
        }

        return A;
    }
}

