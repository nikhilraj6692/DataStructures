package preparation.list;

/*
naive way is to iterate it once and keep it into a set or something and create a new list iterating the set elements..
another way is to start iterating from head and do a while loop for the same node from its next to end of the list and
keep swapping elements till you find that head data is greater than next data...like a bubble sort...
for(int i=0;i<arr.length;i++){
    for(j=i+1;j<arr.length;j++{
        if(arr[i]>arr[j])
            swap elements(here node data)
    }
}
 */
public class Test07SortAList {
    public static void main(String[] args) {
        int[] keys = {6, 3, 4, 8, 2, 9};
        Node<Integer> root = ListBuilder.createLinkedList(keys);

        //sort a linked list
        sortList(root);
        Test01ListIntro.printList(root);
    }

    private static Node<Integer> sortList(Node<Integer> head) {
        Node<Integer> temp = head;

        Node<Integer> currentPointer = null;
        while(null!=temp){
            currentPointer = temp.next;
            while(null!=currentPointer){
                if(currentPointer.data < temp.data){
                    swapNodesData(currentPointer, temp);
                }
                currentPointer = currentPointer.next;
            }
            temp = temp.next;
        }

        return head;
    }

    private static void swapNodesData(Node<Integer> node, Node<Integer> temp) {
        int data = node.data;
        node.data = temp.data;
        temp.data = data;
    }
}
