package preparation.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import preparation.util.Node;
import preparation.util.TreeBuilder;

/* Construct the following tree
                  1
                /   \
               /     \
              2       3
             /      /   \
            /      /     \
           4      5       6
                 / \
                /   \
               7     8
       */
public class Test06LevelOrderTraversalAndSum
{

    public static void main(String[] args)
    {
        Node node = TreeBuilder.buildTree();
        traverseLevelWise(node);
        traverseBFS(node);
        System.out.println();

    }

    private static void traverseBFS(Node node) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int cnt = 0;

            while(cnt < size){
                Node temp = queue.poll();
                if(map.containsKey(level)){
                    int sum = (int)temp.data + map.get(level);
                    map.put(level, sum);
                }else{
                    map.put(level, (int)temp.data);
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }

                if(temp.right!=null){
                    queue.add(temp.right);
                }
                cnt++;

            }
            level++;
        }

        System.out.println(map.values());
    }

    public static void traverseLevelWise(Node<Integer> node)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Map<Node<Integer>, Integer> map = new HashMap<>();

        Node<Integer> temp = null;
        map.put(node, 0);
        int level = 0;
        int maxLevel = 0;
        while (!queue.isEmpty())
        {
            //map.put((temp = queue.poll()),level);
            temp = queue.poll();
            if (temp.left != null)
            {
                queue.add(temp.left);
                level = map.get(temp);
                map.put(temp.left, ++level);
            }
            if (temp.right != null)
            {
                queue.add(temp.right);
                level = map.get(temp);
                map.put(temp.right, ++level);
            }
            //maxLevel = Math.max(maxLevel, level);
        }

        int[] sum = new int[level + 1];
        for (Map.Entry<Node<Integer>, Integer> entry : map.entrySet())
        {
            sum[entry.getValue()] += entry.getKey().data;
        }
        Arrays.stream(sum).forEach(x -> System.out.print(x + " "));
    }
}
