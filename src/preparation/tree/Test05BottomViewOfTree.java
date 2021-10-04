package preparation.tree;

import preparation.util.Node;
import preparation.util.Pair;
import preparation.util.TreeBuilder;

import java.util.*;

//find horizontal distance at each level and print last node at that level
public class Test05BottomViewOfTree {
    public static void main(String[] args) {
        Node node = TreeBuilder.buildTree();
        findBottomViewOfTree(node);

        System.out.println();

        Node node1 = TreeBuilder.buildTree1();
        findBottomViewOfTree(node1);

        System.out.println();

        Node node2 = TreeBuilder.buildTree2();
        findBottomViewOfTree(node2);
        System.out.println();

        node2 = TreeBuilder.buildTree2();
        Map<Integer, Pair<Node,Integer>> map =new TreeMap<>();
        traverseDFSWise(map,0, 0, Pair.of(node2, 0), node2);
        Collection<Pair<Node,Integer>> values=map.values();
        values.stream().forEach(x->System.out.print(x.first+" "));

    }

    /*
    for recursive we have to check two things...one is the horizontal distance for sure and another is level...
    if map does not contain horizontal distance, then put it into map, there is one more case...suppose we have
    a node with a horizontal distance in map but for another node having same horizontal distance, if level is more
    then update map entry...do a preorder traversal
     */
    private static void traverseDFSWise(Map<Integer, Pair<Node,Integer>> map, int hd, int level, Pair<Node,Integer> pair, Node node) {
        if(node==null)
            return;

        map.compute(hd, (key,val)->{
           if(val==null) {
                val = Pair.of(node, level);
           }else {
               if(level>pair.second){
                   val = Pair.of(node, level);
               }
           }
           return val;
        });
        traverseDFSWise(map,hd-1, level+1, pair,node.left);
        traverseDFSWise(map,hd+1, level+1, pair,node.right);

    }

    private static void findBottomViewOfTree(Node node) {
        Map<Integer, Node> map = new TreeMap<>();
        Queue<Node> queue =new LinkedList<>();
        node.hd = 0;
        map.put(node.hd, node);
        queue.add(node);

        Node temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            int hd = temp.hd;

            if(null!= temp.left){
                map.put(hd-1, temp.left);
                temp.left.hd = hd -1;
                queue.add(temp.left);
            }

            if(null!= temp.right){
                map.put(hd+1, temp.right);
                temp.right.hd = hd +1;
                queue.add(temp.right);
            }
        }

        List<Integer> arrayList = new ArrayList<>();

        Collection<Node> values=map.values();
        values.stream().forEach(x->System.out.print(x+" "));
        /*map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(x->{
            System.out.println(x.getKey() +  " " + x.getValue().data);
            arrayList.add((int)x.getValue().data);
        });*/

        //arrayList.stream().forEach(x->System.out.print(x + " "));
    }
}
