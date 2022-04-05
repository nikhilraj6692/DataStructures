package preparation;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description

A hotel manager has to process N advance bookings of rooms for the next season. His hotel has C
rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there
are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in
time O(N log N) .



Input Format
First argument is an integer array A containing arrival time of booking.

Second argument is an integer array B containing departure time of booking.

Third argument is an integer C denoting the count of rooms.



Output Format
Return True if there are enough rooms for N bookings else return False.

Return 0/1 for C programs.



Example Input
Input 1:

 A = [1, 3, 5]
 B = [2, 6, 8]
 C = 1


Example Output
Output 1:

 0


Example Explanation
Explanation 1:

 At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class Test01CheckHotelRoomsCapacity
{

    public static void main(String[] args)
    {
        System.out.print(hotel(Arrays.asList(1, 3, 5), Arrays.asList(2, 6, 8), 1));
    }

    public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K)
    {
        int count = 0;
        PriorityQueue<Integer> departDateQ = new PriorityQueue<>();
        Collections.sort(arrive);
        Collections.sort(depart);

        for (int i = 0; i < arrive.size(); i++)
        {
            if (departDateQ.size() > 0)
            {
                if (arrive.get(i) >= departDateQ.peek())
                {
                    departDateQ.poll();
                    departDateQ.add(depart.get(i));
                } else
                {
                    if (count + 1 > K)
                    {
                        return false;
                    } else
                    {
                        departDateQ.add(depart.get(i));
                        count++;
                    }
                }
            } else
            {
                departDateQ.add(depart.get(i));
                count++;
            }
        }

        return true;
    }
}


