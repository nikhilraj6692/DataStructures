package preparation.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import preparation.util.Pair;

/*
Find the maximum number of activities that can be solved by a person such that the person solves
one activity at a
time...in this problem, we can have max number of activities if we use the condition that the
start time of an
activity can be same or greater than the finish time of previous activity
 */
public class Test37ActivitySelection
{

    public static void main(String[] args)
    {
        // List of given jobs. Each job has an identifier, a deadline, and a
        // profit associated with it
        List<Pair<Integer, Integer>> activities = Arrays.asList(Pair.of(1, 4), Pair.of(3, 5),
            Pair.of(0, 6), Pair.of(5, 7), Pair.of(3, 8),
            Pair.of(5, 9), Pair.of(6, 10), Pair.of(8, 11),
            Pair.of(8, 12), Pair.of(2, 13), Pair.of(12, 14));

        Set<Pair<Integer, Integer>> result = selectActivity(activities);
        for (Pair<Integer, Integer> pair : result)
        {
            System.out.println(pair.first + " , " + pair.second);
        }
    }

    private static Set<Pair<Integer, Integer>> selectActivity(
        List<Pair<Integer, Integer>> activities)
    {
        //sort pairs on basis of finish time...
        Collections.sort(activities, Comparator.comparingInt(Pair::getSecond));
        Set<Pair<Integer, Integer>> result = new HashSet<>();

        if (activities.size() > 0)
        {
            result.add(Pair.of(activities.get(0).first, activities.get(0).second));
        }
        int k = 0;
        for (int i = 1; i < activities.size(); i++)
        {
            if (activities.get(i).first >= activities.get(k).second)
            {
                k = i;
                result.add(Pair.of(activities.get(i).first, activities.get(i).second));
            }
        }

        return result;
    }
}
