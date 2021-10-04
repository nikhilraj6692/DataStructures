package preparation.tree;

import preparation.util.Node;
import preparation.util.Pair;
import preparation.util.TreeBuilder;

import java.util.*;

public class Test10PrintCousinsOfABinaryTree {
    public static void main(String[] args) {
        Node<Integer> node = TreeBuilder.buildTree3();
        List<Integer> arrayList= new ArrayList<>();

        findCousinsOfABinaryTree(arrayList, new Node(6), node);

        arrayList.stream().forEach(x->System.out.print(x + " , "));

    }

    private static void findCousinsOfABinaryTree(List<Integer> arrayList, Node nodeKey, Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Map<Node<Integer>, Pair<Node<Integer>, Integer>> map =new LinkedHashMap<>();
        map.put(root, Pair.of(null, 0));
        int level = 0;
        Node parentNode = null;

        Node temp = null;
        int level1 = 0;
        while(!q.isEmpty()){
            temp =q.poll();
            level = map.get(temp).second + 1 ;

            if(null!=temp.left){
                q.add(temp.left);
                map.put(temp.left, Pair.of(temp, level));
                if(nodeKey.data == temp.left.data){
                    level1 = level;
                    parentNode = temp;
                }
            }

            if(null!=temp.right){
                q.add(temp.right);
                map.put(temp.right, Pair.of(temp, level));
            }
        }


        int finalLevel = level1;
        Node finalParentNode = parentNode;
        map.entrySet().stream().forEach(x->{
            System.out.println(x.getKey().data + " , { " + (null!=x.getValue().first?x.getValue().first.data : "") + " , " + x.getValue().second + " } ");

            if(x.getKey().data!=nodeKey.data && x.getValue().second == finalLevel && x.getValue().first!= finalParentNode){
                arrayList.add(x.getKey().data);
            }

        });


    }
}
