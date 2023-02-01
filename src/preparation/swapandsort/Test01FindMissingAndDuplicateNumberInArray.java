package preparation.swapandsort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Test01FindMissingAndDuplicateNumberInArray
{

    public static void main(String[] args)
    {
        int arr[] = new int[]{247, 240, 303, 9, 304, 105, 44, 204, 291, 26, 242, 2, 358, 264, 176,
            289, 196, 329, 189, 102, 45, 111, 115, 339, 74, 200, 34, 201, 215, 173, 107, 141, 71,
            125, 6, 241, 275, 88, 91, 58, 171, 346, 219, 238, 246, 10, 118, 163, 287, 179, 123, 348,
            283, 313, 226, 324, 203, 323, 28, 251, 69, 311, 330, 316, 320, 312, 50, 157, 342, 12,
            253, 180, 112, 90, 16, 288, 213, 273, 57, 243, 42, 168, 55, 144, 131, 38, 317, 194, 355,
            254, 202, 351, 62, 80, 134, 321, 31, 127, 232, 67, 22, 124, 271, 231, 162, 172, 52, 228,
            87, 174, 307, 36, 148, 302, 198, 24, 338, 276, 327, 150, 110, 188, 309, 354, 190, 265,
            3, 108, 218, 164, 145, 285, 99, 60, 286, 103, 119, 29, 75, 212, 290, 301, 151, 17, 147,
            94, 138, 272, 279, 222, 315, 116, 262, 1, 334, 41, 54, 208, 139, 332, 89, 18, 233, 268,
            7, 214, 20, 46, 326, 298, 101, 47, 236, 216, 359, 161, 350, 5, 49, 122, 345, 269, 73,
            76, 221, 280, 322, 149, 318, 135, 234, 82, 120, 335, 98, 274, 182, 129, 106, 248, 64,
            121, 258, 113, 349, 167, 192, 356, 51, 166, 77, 297, 39, 305, 260, 14, 63, 165, 85, 224,
            19, 27, 177, 344, 33, 259, 292, 100, 43, 314, 170, 97, 4, 78, 310, 61, 328, 199, 255,
            159, 185, 261, 229, 11, 295, 353, 186, 325, 79, 142, 223, 211, 152, 266, 48, 347, 21,
            169, 65, 140, 83, 156, 340, 56, 220, 130, 117, 143, 277, 235, 59, 205, 153, 352, 300,
            114, 84, 183, 333, 230, 197, 336, 244, 195, 37, 23, 206, 86, 15, 187, 181, 308, 109,
            293, 128, 66, 270, 209, 158, 32, 25, 227, 191, 35, 40, 13, 175, 146, 299, 207, 217, 281,
            30, 357, 184, 133, 245, 284, 343, 53, 210, 306, 136, 132, 239, 155, 73, 193, 278, 257,
            126, 331, 294, 250, 252, 263, 92, 267, 282, 72, 95, 337, 154, 319, 341, 70, 81, 68, 160,
            8, 249, 96, 104, 137, 256, 93, 178, 296, 225, 237};

        int n = arr.length;
        //O(n) time complexity
        printTwoElementsBySwapAndSort(arr, n);

        System.out.print("\n========================\n");
        arr = new int[]{2, 3, 1, 8, 2, 3, 5, 1};
        printTwoElementsByMap(arr, n);
    }

    /*
    create a map and put the value of arrays and its count. iterate map and find what is required
     */
    private static void printTwoElementsByMap(int[] arr, int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            map.compute(arr[i], (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i = 0; i < arr.length; i++)
        {
            if (map.get(i + 1) == null)
            {
                System.out.println("Missing number is " + (i + 1));
            } else if (map.get(i + 1) > 1)
            {
                System.out.println("Repeated number is " + (i + 1));
            }
        }
    }

    /*
    keep on swapping the element at index i with element at (element at index i-1) till the
    element at index i satisfies the cond.
    that element at i is equal to i+1. As soon as it is satisfied, increment i and do the same
    thing. once this is complete, traverse
    the array and the element, if not equal to i+1 is the repeated element and i+1 is the missing
     number
     */
    private static void printTwoElementsBySwapAndSort(int[] arr, int n)
    {
        //swap and sort
        int[] swappedArray = swap(arr);
        for (int i = 0; i < swappedArray.length; i++)
        {
            if (arr[i] != i + 1)
            {
                System.out.println("Repeated number is " + arr[i]);
                System.out.println("Missing number is " + (i + 1));
                //if there is more than one missing and repeated number, then remove this break;
                break;
            }
        }
    }

    private static int[] swap(int[] arr)
    {
        for (int i = 0; i < arr.length; )
        {
            if (arr[i] == arr[arr[i] - 1])
            {
                i++;
            } else
            {
                //crucial swap...check here. temp is not assigned to arr[arr[i]-1], since arr[i] value is already assigned to
                //arr[i]
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }

        }

        return arr;
    }
}



