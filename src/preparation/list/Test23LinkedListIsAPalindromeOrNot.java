package preparation.list;

import java.util.concurrent.atomic.AtomicBoolean;

public class Test23LinkedListIsAPalindromeOrNot {
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 3, 2, 1};
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        System.out.println(checkIfPalindromeOrNot(head));
        
        System.out.println();
        keys = new int[]{ 1, 2, 3, 3, 2, 1};
        head = ListBuilder.createLinkedList(keys);

        System.out.println(checkIfPalindromeOrNotRecursively(head));
    }


    static class NodeWrapper
    {
        public Node node;

        NodeWrapper(Node node) {
            this.node = node;
        }
    }

    public static boolean checkPalindrome(NodeWrapper left, Node right)
    {
        // base case
        if (right == null) {
            return true;
        }

        boolean result = checkPalindrome(left, right.next) &&
                (left.node.data == right.data);
        left.node = left.node.next;

        return result;
    }

    // Function to check if the linked list is a palindrome or not
    public static boolean


    checkIfPalindromeOrNotRecursively(Node head)
    {
        // Wrap the `head` node, so its reference can be changed inside the
        // `checkPalindrome()`
        return checkPalindrome(new NodeWrapper(head), head);
    }
    //find mid...if while fiding mid, odd is set to true, then mark mid to mid.next. Odd can be set by checking if after while loop is covered,
    //still fastnode is null or not. If fast node is not null, then set odd to true. Then reverse the mid and compare head and mid
    private static boolean checkIfPalindromeOrNot(Node<Integer> head) {
        Node mid = findMidNode(head);

        if(odd.get()){
            mid= mid.next;
        }

        Node reversedNode = reverse(mid);

        //check for palindrome
        while(head!=null && reversedNode!=null){
            if(head.data != reversedNode.data)
                return false;
            head = head.next;
            reversedNode = reversedNode.next;
        }

        return true;
     }

    private static Node reverse(Node mid) {
        if(mid == null)
            return null;

        Node curr = mid;
        Node prevNode = null;

        while(curr!=null){
            Node nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }

        return prevNode;
    }

    private static AtomicBoolean odd = new AtomicBoolean();

    private static Node findMidNode(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = slow;
        Node<Integer> prevNode = null;

        while(null!=fast && null!=fast.next){
            prevNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(null!=fast){
            odd.set(true);
        }

        prevNode.next = null;

        return slow;
    }
}
