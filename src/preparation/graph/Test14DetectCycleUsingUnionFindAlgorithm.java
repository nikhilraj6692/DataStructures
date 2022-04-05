package preparation.graph;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test14DetectCycleUsingUnionFindAlgorithm
{

    public static void main(String[] args)
    {
        /*
         In this algorithm, all vertices are created as a subset and as and when edges are
         iterated, then union of subsets take
         place in such a way that both subsets are merged with one another and one vertex becomes
          parent of another. Finding any key
         will result in value of the parent of that subset. Ex: lets say that there are 3
         vertices, i.e., 0,1 and 2. Lets create
         3 subsets as in {0}, {1}, {2}. Lets have three edges: (0,1), (1,2), (2,0). If we do
         union of (0,1), then 1 will become parent
         of 0 or vice versa. Hence finding (1) or finding (0) will result in 1 only. This way if
         a graph is created then it will create
         a directed edge from 0 to 1.

         After: (0,1)
         0----->1

         After: (1,2)
         0----->1------>2

         After: (2,0)
         0----->1------>2
         ^             /
         |____________/

         This way if two edges lie in the same subset, finding 0 and 2 will give same parent 0
         (Same subset as 2 is representative of
         0, 1, 2 here), then a cycle is formed. Also, this algorithm can have a worst time
         complexity as a linked list if below case
         is considered

         Let there be 4 elements 0, 1, 2, 3

        Initially, all elements are single element subsets.
        0 1 2 3

        Do Union(0, 1)
           1   2   3
          /
         0

        Do Union(1, 2)
             2   3
            /
           1
         /
        0

        Do Union(2, 3)
                 3
                /
              2
             /
           1
         /
        0

        this will become skewed and will become like linked list
         */

        // universe of items
        int[] universe = {1, 2, 3, 4, 5};

        /*DisjointSet ds = new DisjointSet();
        ds.makeSet(universe);
        ds.printSet();

        if(ds.union(4, 3)){
            System.out.print("Cycle is found");
            return;
        }
        ds.printSet();

        if(ds.union(2, 1)){
            System.out.print("Cycle is found");
            return;
        }
        ds.printSet();

        if(ds.union(1, 3)){
            System.out.print("Cycle is found");
            return;
        }
        ds.printSet();

        //below union is forming a cycle
        if(ds.union(2, 4)){
            System.out.print("Cycle is found");
            return;
        }
        ds.printSet();

        System.out.print("Cycle is not found");
        return;*/

        /*
        As discussed above algorithm may result in O(n) in worst time complexity. To remove this,
         we use the idea of union by rank
        and path compression algorithm. In this algorithm, initially we assign rank of all
        vertices as 0. Now while doing union of
        vertices, firstly check if both vertices are having same parent or not. If then it forms
        a cycle and return. But if it
        does not, then check the rank of both vertices, if same then make one vertex parent of
        other and increase rank of parent by 1.
        If less, then make the parent of one vertex with less rank child of another vertex and
        vice versa for greater. Do this until
        all unions or edges are iterated. This reduces the time complexity of searching any
        vertex to O(logn)
         */
        DisjointSetByRank ds = new DisjointSetByRank();

        // create a singleton set for each element of the universe
        ds.makeSet(universe);
        ds.printSet();

        if (ds.union(4, 3))
        {
            System.out.print("Cycle is found");
            return;
        }
        ds.printSet();

        if (ds.union(2, 1))
        {
            System.out.print("Cycle is found");
            return;
        }
        ds.printSet();

        if (ds.union(1, 3))
        {
            System.out.print("Cycle is found");
            return;
        }
        ds.printSet();

        //below union is forming a cycle
        if (ds.union(2, 4))
        {
            System.out.print("Cycle is found");
            return;
        }

        System.out.print("Cycle is not found");
        return;

    }
}

class DisjointSet
{

    Map<Integer, Integer> universeMap = new LinkedHashMap<>();

    public void makeSet(int[] universe)
    {
        for (int elem : universe)
        {
            universeMap.put(elem, elem);
        }
    }

    public void printSet()
    {
        for (Map.Entry<Integer, Integer> entry : universeMap.entrySet())
        {
            System.out.print(find(entry.getKey()) + " ");
        }
        System.out.println();
    }

    public int find(int key)
    {
        if (universeMap.get(key) == key)
        {
            return key;
        }

        return find(universeMap.get(key));
    }

    public boolean union(int v1, int v2)
    {
        int x = find(v1);
        int y = find(v2);

        if (x == y)
        {
            return true;
        }

        universeMap.put(x, y);
        return false;
    }

    public void makeSet(int n)
    {
        for (int i = 0; i < n; i++)
        {
            universeMap.put(i, i);
        }
    }
}

class DisjointSetByRank
{

    Map<Integer, Subset> map = new LinkedHashMap<>();

    public void printSet()
    {
        for (Map.Entry<Integer, Subset> entry : map.entrySet())
        {
            System.out.print(find(entry.getKey()) + " ");
        }
        System.out.println();
    }

    private int find(int key)
    {
        if (map.get(key).parent == key)
        {
            return key;
        }

        return find(map.get(key).parent);
    }

    public boolean union(int v1, int v2)
    {
        int x = find(v1);
        int y = find(v2);

        if (x == y)
        {
            return true;
        }

        Subset subsetX = map.get(x);
        Subset subsetY = map.get(y);

        if (subsetX.rank < subsetY.parent)
        {
            subsetX.parent = y;
        } else if (subsetX.rank > subsetY.parent)
        {
            subsetY.parent = x;
        } else
        {
            subsetX.parent = y;
            subsetY.rank++;
        }

        return false;
    }

    class Subset
    {

        private int rank;
        private int parent;
    }

    public void makeSet(int[] universe)
    {
        for (int elem : universe)
        {
            Subset subset = new Subset();
            subset.parent = elem;
            subset.rank = 0;
            map.put(elem, subset);
        }
    }
}
