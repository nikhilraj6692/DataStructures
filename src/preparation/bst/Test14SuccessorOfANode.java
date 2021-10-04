package preparation.bst;

import preparation.util.Node;

public class Test14SuccessorOfANode {
    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);

        /* Construct the following tree
                   15
                 /    \
                /      \
               10       20
              / \      /  \
             /   \    /    \
            8    12  16    25
        */

        for (int key: keys)
        {
            Node prec = findSuccessorIterative(root, null, key);

            if (prec != null)
            {
                System.out.println("The successor of node " + key + " is "
                        + prec.data);
            }
            else {
                System.out.println("The successor doesn't exist for node "
                        + key);
            }
        }

        System.out.print("----------------------------------------------------\n");
        for (int key: keys)
        {
            Node prec = findSuccessorRecursive(root, null, key);

            if (prec != null)
            {
                System.out.println("The successor of node " + key + " is "
                        + prec.data);
            }
            else {
                System.out.println("The successor doesn't exist for node "
                        + key);
            }
        }
    }

    private static Node findSuccessorRecursive(Node<Integer> root, Node<Integer> prevNode, int key) {
        if(root.data == key){
            if(null!= root.right) {
                return findMinimum(root.right);
            }else{
                return prevNode;
            }
        }

        if(key < root.data){
            prevNode = root;
            return findSuccessorRecursive(root.left, prevNode, key);
        }else if (key > root.data){
            return findSuccessorRecursive(root.right, prevNode, key);
        }
        return null;
    }

    private static Node findSuccessorIterative(Node<Integer> root, Node<Integer> prevNode, int key) {
        Node<Integer> curr = root;

        while(null!=curr){
            if(curr.data == key){
                if(null!= curr.right) {
                    return findMinimum(curr.right);
                }else{
                    return prevNode;
                }
            }
            if(key < curr.data){
                prevNode = curr;
                curr = curr.left;
            }else if(key > curr.data){
                curr = curr.right;
            }
        }

        return prevNode;
    }

    private static Node findMinimum(Node<Integer> curr) {
        while(null!=curr.left){
            curr = curr.left;
        }

        return curr;
    }
}
