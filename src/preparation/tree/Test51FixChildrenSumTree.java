package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test51FixChildrenSumTree {
    public static void main(String[] args) {
        Node<Integer> node = TreeBuilder.buildTree17();
        fixTree(node);
        Test01InorderTraversal.inOrderTraversal(node);
    }

    private static void fixTree(Node<Integer> node) {
        if(node == null || (node.left==null && node.right == null))
            return;


        fixTree(node.left);
        fixTree(node.right);

        int sum = node.left.data + node.right.data;
        int diff = node.data - sum;

        if(diff<0)
            node.data+=Math.abs(diff);
        else{
            Node<Integer> temp = node.left!=null?node.left:node.right;
            temp.data+=diff;
            fixTree(temp);
        }

    }
}
