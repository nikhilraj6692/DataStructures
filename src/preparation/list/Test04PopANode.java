package preparation.list;

/*
it will pop the last node of the linked list as it will be like a stack over here...also we will have to maintain a previous
node because we want the last node and node before it so that when we reach last node, we can do prevNode.next = null
 */
public class Test04PopANode {
    public static void main(String[] args) {
        Node<Integer> root = ListBuilder.buildList1();
        root = popNode(root);
        Test01ListIntro.printList(root);
    }

    private static Node<Integer> popNode(Node<Integer> root) {
        Node<Integer> temp = root;
        Node<Integer> prevNode = null;

        while(temp.next!=null){
            prevNode = temp;
            temp = temp.next;
        }

        prevNode.next = null;
        return root;
    }
}
