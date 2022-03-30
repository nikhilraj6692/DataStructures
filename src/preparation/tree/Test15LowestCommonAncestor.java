package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Test15LowestCommonAncestor {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree2();

        System.out.println(findLCAApproach1(root, root.right.left.left, root.right.right));
        System.out.println(findLCAApproach1(root, root.right.left.left, new Node(10)));
        System.out.println(findLCAApproach1(root, root.right.left.left, root.right.left.left));
        System.out.println(findLCAApproach1(root, root.right.left.left, root.right.left));
        System.out.println(findLCAApproach1(root, root.left, root.right.left));
    }

    /*
    find the root from root to node1, keep it in an array. Similarly, for node2 and then match the elements in both arrays.
    if the element is not present in the path after iterating node's left and right then remove the last element from the array
     */
    private static int findLCAApproach1(Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Node temp = root;
        boolean path1 = findPathApproach1(temp,node1,list1);
        temp = root;
        boolean path2 = findPathApproach1(temp, node2, list2);

        if(!path1 || !path2){
            return -1;

        }else{
            int i=0;
            for(i=0;i<list1.size() && i<list2.size(); i++){
                if(list1.get(i) != list2.get(i)){
                    break;
                }
            }


            return list1.get(i-1);
        }
    }

    private static boolean findPathApproach1(Node<Integer> root, Node<Integer> node, List<Integer> list) {
        if(root == null)
            return false;

        list.add(root.data);
        if(root == node)
            return true;

        if(findPathApproach1(root.left, node, list) || findPathApproach1(root.right, node, list))
            return true;


        list.remove(list.size()-1);
        return false;
    }
}
