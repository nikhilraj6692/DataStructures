package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class Test04IdenticalBinaryTrees {
    public static void main(String[] args) {
        Node node1 = TreeBuilder.buildTree();
        Node node2 = TreeBuilder.buildTree();
        node1.right.left.right = new Node(9);
        //node2.right.left.right = new preparation.util.Node(13);

        System.out.println(isIdentical2(node1,node2));

        System.out.println(isIdenticalIterative(node1, node2));
    }

    private static boolean isIdenticalIterative(Node node1, Node node2) {
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(node1);
        queue2.add(node2);

        Node temp1 = null;
        Node temp2 = null;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            temp1 = queue1.poll();
            temp2 = queue2.poll();
            if(null != temp1.data && null!=temp2.data && temp1.data != temp2.data)
                return false;

            if(null != temp1.left && null!=temp2.left){
                queue1.add(temp1.left);
                queue2.add(temp2.left);
            }else if(null!=temp1.left || null!=temp2.left){
                return false;
            }

            if(null != temp1.right && null!=temp2.right){
                queue1.add(temp1.right);
                queue2.add(temp2.right);
            }else if(null!=temp1.right || null!=temp2.right){
                return false;
            }

        }

        return true;
    }

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
    private static boolean isIdentical(Node node1, Node node2) {

        Node temp1 = node1;
        Node temp2 = node2;

        if(null!=temp1 && null!=temp2 && temp1.data == temp2.data){
            if(isIdentical(temp1.left, temp2.left) && isIdentical(temp1.right, temp2.right)){
                return true;
            }
            else{
                return false;
            }
        }else if (null == temp1 && null == temp2)
            return true;
        else
            return false;

    }

    private static boolean isIdentical2(Node node1, Node node2) {

       if(node1==null && node2==null)
           return true;

       if((node1==null && node2!=null) || (node1!=null && node2==null) ||(node1.data!=node2.data)){
           return false;
       }

       return isIdentical2(node1.left, node2.left) && isIdentical2(node1.right, node2.right);



    }
}
