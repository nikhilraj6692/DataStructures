package preparation.tree;

import preparation.util.Node;
import preparation.util.NodeInfo;
import preparation.util.Pair;
import preparation.util.TreeBuilder;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/*
Two nodes are cousins of each other if they are at same level and have different parents
 */
public class Test09CousinNodes {
    public static void main(String[] args) {
        Node<Integer> node = TreeBuilder.buildTree3();

        findCousinsOrNot(node, 4, 5);
        findCousinsOrNot(node, 5, 6);
    }

    private static void findCousinsOrNot(Node<Integer> node, int firstNode, int secondNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Node temp = null;
        Map<Node<Integer>, Pair<Node<Integer>, Integer>> map =new LinkedHashMap<>();
        map.put(node, Pair.of(null, 0));
        int level = 0;
        while(!queue.isEmpty()){
            temp=queue.poll();
            level = map.get(temp).second + 1;
            if(null!=temp.left){
                map.put(temp.left, Pair.of(temp, level));
                queue.add(temp.left);
            }

            if(null!=temp.right){
                map.put(temp.right, Pair.of(temp, level));
                queue.add(temp.right);
            }
        }

        AtomicReference<NodeInfo> nodeInfo1 = new AtomicReference<>();
        AtomicReference<NodeInfo> nodeInfo2 = new AtomicReference<>();

        map.entrySet().stream().forEach((kv)->{
            System.out.println( kv.getKey().data + " , { " + (null!=kv.getValue().first? kv.getValue().first.data: "" )+ " , "  + kv.getValue().second + " } ");
            if(kv.getKey().data == firstNode){
                nodeInfo1.set(new NodeInfo(kv.getKey().data, kv.getValue().second, kv.getValue().first));
            }
            else if(kv.getKey().data == secondNode){
                nodeInfo2.set(new NodeInfo(kv.getKey().data, kv.getValue().second, kv.getValue().first));
            }
        });

        if(nodeInfo1.get().parent != nodeInfo2.get().parent && nodeInfo1.get().level == nodeInfo2.get().level){
            System.out.println("Both are cousins of each other");
        } else{
            System.out.println("Both are not cousins of each other");
        }


    }
}
