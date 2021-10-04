package preparation.bst;

import preparation.util.Node;


public class Test06CheckIfBinaryTreeIsABST {
    public static void main(String[] args) {
        int[] keys = { 20,10,30,25,40};
        /* Construct the following tree,,
                   20
                 /    \
                /      \
               10       30
                       /  \
                      /    \
                     25    40
        */
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        //swap(root);
        root.right.left.data = 5;
        if (checkIfTreeIsABST(root, null)) {
            System.out.println("Is a BST");
        } else {
            System.out.println("Is not a BST");
        }

        System.out.print("\n--------------------------------\n");
        if (checkIfTreeIsABSTWithRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("Is a BST");
        } else {
            System.out.println("Is not a BST");
        }
    }

    private static boolean checkIfTreeIsABSTWithRange(Node<Integer> root, int minValue, int maxValue) {
        if(root == null)
            return true;
        if(root.data < minValue || root.data > maxValue)
            return false;

        return checkIfTreeIsABSTWithRange(root.left, minValue, root.data) && checkIfTreeIsABSTWithRange(root.right,root.data, maxValue);
    }

    /*
    Inorder of a BST is always sorted. Check if rootNode is smaller or equal to prevNode then certainly it is not in BST.
    Recursive inorder will work. Since, we have to return boolean so return true in case you hit leaf node. Can be done with list instead of prev
    node
     */
    private static boolean checkIfTreeIsABST(Node<Integer> root, Node<Integer> prevNode) {
        if(null == root)
            return true;

        boolean left = checkIfTreeIsABST(root.left, prevNode);

        //can be done with list..in this case just pass list from the function checkIfTreeIsABST(root, new ArrayList<>())
        //in main function
        /*list.add(root.data);

        if(list.size()>1 && list.get(list.size()-1) <= list.get(list.size()-2)){
            return false;
        }*/

        if(prevNode!=null && root.data<=prevNode.data){
            return false;
        }
        prevNode = root;

        return left && checkIfTreeIsABST(root.right, prevNode);
    }

    private static void swap(Node root) {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }
}
