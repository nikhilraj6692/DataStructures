package preparation.list;

/*
6 9 3 8 7...just have prev and curr and swap
 */
public class Test29AlternatingHighAndLows {
    public static void main(String[] args) {
        int[] keys = { 9, 6, 8, 3, 7 };
        Node<Integer> head = ListBuilder.createLinkedList(keys);

        Test01ListIntro.printList(arrangeInAlternatingHighAndLow(head));
    }


    //{ 1, 3, 2, 4, 5, 6, 7, 8, 6 };

    /*
    1: prev = 1, curr= 2
    2: prev = 3, curr = 2;
     */
    private static Node<Integer> arrangeInAlternatingHighAndLow(Node<Integer> head) {
        Node<Integer> temp = head;
        int count =0;
        Node<Integer> prevNode = null;

        while(null!=temp){
            count++;

            if(count%2 == 0){
                if(temp.data<prevNode.data){
                    swap(temp, prevNode);
                }else if(null!=temp.next && temp.data < temp.next.data){
                    swap(temp, temp.next);
                }
            }

            prevNode = temp;
            temp = temp.next;
        }
        return head;
    }

    private static void swap(Node<Integer> temp, Node<Integer> prevNode) {
        int data = temp.data;
        temp.data = prevNode.data;
        prevNode.data = data;
    }
}
