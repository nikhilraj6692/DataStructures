package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test29CreateLinkForInorderSuccessors {
    public static void main(String[] args) {
        Node<Integer> node = TreeBuilder.buildTree();

        findAndLinkInorderSuccessor(node);

        while(node.left!=null){
            node=node.left;
        }
        while(null!=node && node.data!=-1){
            if(node.next == null){
                System.out.println("The inorder successor of node " + node.data + " is " + -1);
            }else {
                System.out.println("The inorder successor of node " + node.data + " is " + node.next.data);
            }
            node = node.next;
        }
    }

    private static Node<Integer> processedNode = null;

    private static void findAndLinkInorderSuccessor(Node<Integer> node) {
        if(node!=null) {
            findAndLinkInorderSuccessor(node.left);
            if(processedNode.data!=null){
                processedNode.next = node;
            }

            processedNode = node;
            findAndLinkInorderSuccessor(node.right);

        }
    }

    /*
    reverse inorder...go to right and then left and in between do same as processed node.
    Node root;
	static Node next = null;

	 Set next of p and all descendents of p by traversing them in
	reverse Inorder
    void populateNext(Node node)
    {
        // The first visited node will be the rightmost node
        // next of the rightmost node will be NULL
        if (node != null)
        {
            // First set the next pointer in right subtree
            populateNext(node.right);

            // Set the next as previously visited node in reverse Inorder
            node.next = next;

            // Change the prev for subsequent node
            next = node;

            // Finally, set the next pointer in left subtree
            populateNext(node.left);
        }
    }
     */
}
