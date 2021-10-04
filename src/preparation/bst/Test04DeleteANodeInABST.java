package preparation.bst;

import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;

public class Test04DeleteANodeInABST {
    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16 };
        Node<Integer> root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        System.out.print("Previous deletion inorder :: ");
        Test01InorderTraversal.inOrderTraversal(root);
        root = deleteANodeInBST(root, 16);
        System.out.println();
        System.out.print("After deletion inorder :: ");
        Test01InorderTraversal.inOrderTraversal(root);

        System.out.println("\n==================");
        keys = new int[] { 15};
        root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        System.out.print("Previous deletion inorder :: ");
        Test01InorderTraversal.inOrderTraversal(root);
        root = deleteANodeInBST(root, 15);
        System.out.println();
        System.out.print("After deletion inorder :: ");
        Test01InorderTraversal.inOrderTraversal(root);

        System.out.println("\n==================");
        keys = new int[] { 15, 10, 20, 8, 12, 18, 25, 16, 19, 30};
        root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        System.out.print("Previous deletion inorder :: ");
        Test01InorderTraversal.inOrderTraversal(root);
        root = deleteANodeInBST(root, 25);
        System.out.println();
        System.out.print("After deletion inorder :: ");
        Test01InorderTraversal.inOrderTraversal(root);

        System.out.println("\n==================");
        keys = new int[] { 15, 10, 20, 8, 12, 18, 30, 16, 19};
        root = Test01InsertionInABST.supplyKeysAndCreateBST(keys);
        System.out.print("Previous deletion inorder :: ");
        Test01InorderTraversal.inOrderTraversal(root);
        root = deleteANodeInBST(root, 20);
        System.out.println();
        System.out.print("After deletion inorder :: ");
        Test01InorderTraversal.inOrderTraversal(root);
    }

    private static Node<Integer> deleteANodeInBST(Node<Integer> root, int key) {
        Node<Integer> curr = root;
        Node<Integer> parent = null;

        while(null!= curr){
            if(key == curr.data){
                break;
            }else if (key < curr.data){
                parent = curr;
                curr = curr.left;
            }else if ( key > curr.data){
                parent = curr;
                curr = curr.right;
            }
        }

        if(curr == null){
            System.out.println("Key is not found in BST");
        }

        /*
        now that curr is found, start checking if it has one child node or two child nodes or no child node. If it does not have any child node,
        then just delete its node or unlink this node from its parent. If it has only one child node, then replace this node with its child node,
        if it has two nodes, then replace it with its inorder successor or inoder predecessor. Inorder successor is the leftmost node of right
        sub tree and inorder predecessor is the rightmost node of its left subtree
         */

        if(curr.left == null && curr.right == null){
            if(curr != root) {
                if (curr.data < parent.data) {
                    parent.left = null;
                } else if (curr.data > parent.data) {
                    parent.right = null;
                }
            }else{
                root = null;
            }
        } else if (curr.left == null || curr.right == null){
            if(curr.left!=null){
                curr.data = curr.left.data;
                curr.left = null;
            }else if (curr.right != null){
                curr.data = curr.right.data;
                curr.right = null;
            }
        } else {
            //having two nodes, find inorder successor
            Node<Integer> leftMostNodeOfRightSubTree = findMinKey(curr.right);

            //now that minimum key is found, start deleting nodes
            deleteANodeInBST(root, leftMostNodeOfRightSubTree.data);

            curr.data = leftMostNodeOfRightSubTree.data;
        }

        return root;
    }

    private static Node<Integer> findMinKey(Node<Integer> node) {
        Node<Integer> curr = node;

        while(curr.left!=null){
            curr = curr.left;
        }

        return curr;
    }
}
