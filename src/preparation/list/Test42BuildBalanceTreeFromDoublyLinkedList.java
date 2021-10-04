package preparation.list;

//here main function is having doubly linked list data, so no need to create doubly linked list and then convert to array
public class Test42BuildBalanceTreeFromDoublyLinkedList {
    public static void main(String[] args) {
        int[] keys = { 8, 10, 12, 15, 18, 20, 25 };
        Node root = createBST(keys, 0, keys.length - 1);
        doPreorder(root);
    }

    private static Node createBST(int[] keys, int s, int e) {
        if(s == e)
            return new Node(keys[s]);

        int mid = (s + e)/2;

        Node root = new Node (keys[mid]);
        root.left = createBST(keys, s, mid - 1);
        root.right = createBST(keys, mid +1, e);

        return root;
    }

    private static void doPreorder(Node root) {
        if(root!=null){
            System.out.print(root.data + " ");
            doPreorder(root.left);
            doPreorder(root.right);
        }
    }
}
