package preparation.list;

public class Test38SwapNthNodeFromStartAndEndInList {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Node<Integer> head = ListBuilder.createLinkedList(arr);
        head = swapFromStartAndEnd(head, 3);
        Test01ListIntro.printList(head);
    }

    //make use of function of n-m item from the list and keep a track of previous pointer of start and end node and then swap
    //but extra care has to be taken when node to be swapped is first or last node or first.next = last or last.next = first
    private static Node<Integer> swapFromStartAndEnd(Node<Integer> head, int k) {
        Node startPointer = head;
        Node prevNodeFromBeginning = null;
        Node prevNodeFromEnd = null;
        Node endPointer = startPointer;

        int i = 1;
        while(null!=startPointer  && i++<k){
            prevNodeFromBeginning = startPointer;
            startPointer = startPointer.next;
        }

        Node backupStartPointer = startPointer;

        while(null!=startPointer.next){
            prevNodeFromEnd = endPointer;
            endPointer = endPointer.next;
            startPointer = startPointer.next;
        }

        if(backupStartPointer.next == endPointer){
            prevNodeFromBeginning.next = endPointer;
            backupStartPointer.next = endPointer.next;
            endPointer.next = backupStartPointer;
        } else if(endPointer.next == backupStartPointer){
            prevNodeFromEnd.next = backupStartPointer;
            endPointer.next = backupStartPointer.next;
            backupStartPointer.next = endPointer;
        } else if(prevNodeFromBeginning==null){
            endPointer.next = backupStartPointer.next;
            prevNodeFromEnd.next = backupStartPointer;
            backupStartPointer.next = null;
            head = endPointer;
        } else if(prevNodeFromEnd==null){
            backupStartPointer.next = endPointer.next;
            prevNodeFromBeginning.next = endPointer;
            endPointer.next = null;
            head = backupStartPointer;
        } else{
            //swap start and backup pointer
            Node nextStart = backupStartPointer.next;
            Node nextEnd = endPointer.next;


            prevNodeFromBeginning.next = endPointer;
            endPointer.next = nextStart;
            prevNodeFromEnd.next = backupStartPointer;
            backupStartPointer.next = nextEnd;
        }

        return head;
    }
}
