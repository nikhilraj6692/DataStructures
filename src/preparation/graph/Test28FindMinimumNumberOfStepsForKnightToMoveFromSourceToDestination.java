package preparation.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import preparation.util.VNode;

public class Test28FindMinimumNumberOfStepsForKnightToMoveFromSourceToDestination
{

    public static void main(String[] args)
    {
        int N = 8;

        // source coordinates
        VNode src = new VNode(0, 7);

        // destination coordinates
        VNode dest = new VNode(7, 0);

        System.out.println("The minimum number of steps required is " +
            findShortestDistance(src, dest, N));
    }

    private static int findShortestDistance(VNode src, VNode dest, int n)
    {
        /*
        The possible combinations for a knight to move from (x,y) to a valid position in one step
         are:
        (x + 2, y – 1)
        (x + 2, y + 1)
        (x – 2, y + 1)
        (x – 2, y – 1)
        (x + 1, y + 2)
        (x + 1, y – 2)
        (x – 1, y + 2)
        (x – 1, y – 2)

        So, make row and column array corresponding to each index
         */
        int[] row = new int[]{2, 2, -2, -2, 1, 1, -1, -1};
        int[] column = new int[]{-1, 1, 1, -1, 2, -2, 2, -2};

        //8*8
        Map<VNode, VNode> parentMap = new HashMap<>();

        Queue<VNode> q = new LinkedList<>();
        q.add(src);

        // set to check if the matrix cell is visited before or not
        Set<VNode> visited = new HashSet<>();

        while (!q.isEmpty())
        {
            VNode sNode = q.poll();
            int sX = sNode.source;
            int sY = sNode.destination;
            int d = sNode.distance;

            if (sX == dest.source && sY == dest.destination)
            {
                //print parent
                findPath(parentMap, sNode);
                return d;
            }

            if (!visited.contains(sNode))
            {
                visited.add(sNode);
                for (int i = 0; i < row.length; i++)
                {
                    int dX = sX + row[i];
                    int dY = sY + column[i];
                    VNode dVNode = new VNode(dX, dY, d + 1);

                    if (dX >= 0 && dX < n && dY >= 0 && dY < n)
                    {
                        q.add(dVNode);
                        parentMap.put(dVNode, sNode);
                    }
                }
            }
        }

        return -1;
    }

    private static void findPath(Map<VNode, VNode> parentMap, VNode sNode)
    {
        if (parentMap.get(sNode) == null)
        {
            System.out.println(sNode.source + " " + sNode.destination + " " + sNode.distance);
            return;
        }

        System.out.println(sNode.source + " " + sNode.destination + " " + sNode.distance);
        findPath(parentMap, parentMap.get(sNode));
    }
}
