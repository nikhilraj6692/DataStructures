package preparation.list;

//can also be done by first reversing, then adding number, then reversing list back again
public class Test33AddANumberToLinkedListAtEnd
{

    public static void main(String[] args)
    {
        int number[] = {9, 9, 9, 9, 9};
        Node<Integer> head = ListBuilder.createLinkedList(number);

        head = addNumberToListRecursive(head, 11);

        Node node = null;
        if (carryForward != 0)
        {
            node = new Node(carryForward);
            node.next = head;
            head = node;
        }

        Test01ListIntro.printList(head);

        System.out.println();
        head = ListBuilder.createLinkedList(number);

        head = addNumberToListIterative(head, 1);
        Test01ListIntro.printList(head);
    }

    private static Node<Integer> addNumberToListIterative(Node<Integer> head, int num)
    {
        //reverse list
        Node<Integer> curr = reverseList(head);
        Node<Integer> backUpNode = null;
        Node<Integer> prevNode = null;
        int carry = 0;
        int sum;
        while (null != curr)
        {
            if (backUpNode == null)
            {
                backUpNode = curr;
                sum = curr.data + carry + num;
            } else
            {
                sum = curr.data + carry;
            }

            if (sum > 9)
            {
                String sumStr = String.valueOf(sum);
                carry = Integer.parseInt(sumStr.substring(0, sumStr.length() - 1));
                int val = Integer.parseInt(sumStr.substring(sumStr.length() - 1));
                curr.data = val;
            } else
            {
                curr.data = sum;
                carry = 0;
            }
            curr = curr.next;
        }

        Node<Integer> finalList = reverseList(backUpNode);

        while (carry > 0)
        {
            int last = carry % 10;
            carry = carry / 10;
            Node<Integer> newNode = new Node<>(last);
            newNode.next = finalList;
            finalList = newNode;
        }
        return finalList;
    }

    private static Node<Integer> reverseList(Node<Integer> head)
    {
        Node<Integer> curr = head;
        Node<Integer> next;
        Node<Integer> prev = null;

        while (null != curr)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static int carryForward = 0;

    private static Node<Integer> addNumberToListRecursive(Node<Integer> head, int numToBeAdded)
    {
        if (head == null)
        {
            return null;
        }

        head.next = addNumberToListRecursive(head.next, numToBeAdded);

        if (head.next == null)
        {
            head.data = head.data + numToBeAdded;
        } else
        {
            head.data = head.data + carryForward;
        }

        if (head.data > 9)
        {
            String headData = String.valueOf(head.data);
            head.data = Integer.parseInt(headData.substring(headData.length() - 1));
            carryForward = Integer.parseInt(headData.substring(0, headData.length() - 1));
        } else
        {
            carryForward = 0;
        }

        return head;
    }
}
