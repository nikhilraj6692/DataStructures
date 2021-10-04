package preparation.list;

//reverse both lists and add and then reverse again
public class Test39AddTwoLinkedList {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 1, 5, 7, 3};
        Node<Integer> list1 = ListBuilder.createLinkedList(arr1);
        int[] arr2 = new int[] {2,2,1,9, 4, 6};
        Node<Integer> list2 = ListBuilder.createLinkedList(arr2);
        Node<Integer> head =  addTwoLinkedLists(list1, list2);
        Test01ListIntro.printList(head);
    }

    private static int carryForward = 0;
    private static Node<Integer> addTwoLinkedLists(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> reversedList1 = reverse(list1);
        Node<Integer> reversedList2 = reverse(list2);
        return reverse(add(reversedList1, reversedList2));
    }

    //4 3 7
    //6 4 9 5
    //0 8 6
    //in the below problem, i have modified list1 which kinds of make it complicated. we can also use any new node and have a link for previous and head node
    private static Node<Integer> add(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> curr1 = head1;
        Node<Integer> curr2 = head2;
        Node prevNode = null;

        while(curr1!=null && curr2!=null){
            int data1 = curr1.data;
            int data2 = curr2.data;
            int addedValue = data1 + data2 + carryForward;

            if(addedValue>9){
                String headData = String.valueOf(addedValue);
                addedValue = Integer.parseInt(headData.substring(headData.length()-1));
                carryForward = Integer.parseInt(headData.substring(0, headData.length()-1));
            }else{
                carryForward = 0;
            }

            curr1.data = addedValue;

            prevNode = curr1;
            curr1= curr1.next;
            curr2 = curr2.next;
        }

        while(curr1!=null){
            int data = curr1.data + carryForward;
            if(data>9){
                String headData = String.valueOf(data);
                data = Integer.parseInt(headData.substring(headData.length()-1));
                carryForward = Integer.parseInt(headData.substring(0, headData.length()-1));
            }else{
                carryForward = 0;
            }
            curr1.data = data;
            curr1 = curr1.next;
        }

        while(curr2!=null){
            int data = curr2.data + carryForward;
            if(data>9){
                String headData = String.valueOf(data);
                data = Integer.parseInt(headData.substring(headData.length()-1));
                carryForward = Integer.parseInt(headData.substring(0, headData.length()-1));
            }else{
                carryForward = 0;
            }
            prevNode.next = new Node(curr2.data);
            prevNode = prevNode.next;
            curr2 = curr2.next;
        }

        if(carryForward!=0){
            prevNode.next = new Node(carryForward);
        }

        return head1;
    }

    private static Node<Integer> reverse(Node<Integer> node){
        Node current = node;
        Node prev = null;

        while(null!=current){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

}
