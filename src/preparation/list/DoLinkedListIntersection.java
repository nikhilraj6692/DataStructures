package preparation.list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class DoLinkedListIntersection {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        //InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        //BufferedReader in = new BufferedReader(reader);
        //String line;
        List<String> list = new ArrayList<>(){{
            add("X->Y");
            add("Y->X");
            add("A->B");
            add("B->C");
            add("X,A");
        }};
        Map<String, Nodes> valToNodesMap = new HashMap<>();
        //while ((line = in.readLine()) != null) {
        for(String line: list) {
            System.out.println(line);

            if(line.contains("->")) {
                String[] srcToDestinationNodess = line.split("->");
                String src = srcToDestinationNodess[0];
                String dest = srcToDestinationNodess[1];


                Nodes srcNodes;
                if(null!= valToNodesMap.get(src)){
                    srcNodes = valToNodesMap.get(src);
                }else{
                    srcNodes = new Nodes(src);
                    valToNodesMap.put(src, srcNodes);
                }

                Nodes destNodes;
                if(null!= valToNodesMap.get(dest)){
                    destNodes = valToNodesMap.get(dest);
                }else{
                    destNodes = new Nodes(dest);
                    valToNodesMap.put(dest, destNodes);
                }

                addToLinkedList(srcNodes, destNodes);

            } else {
                //create linked List and pass to function
                String[] listsVal = line.split(",");
                Collection<SinglyLinkedList> lists = new ArrayList<>();
                for(String val:listsVal) {
                    lists.add(new SinglyLinkedList(valToNodesMap.get(val)));
                }
                Boolean result = doLinkedListIntersect(lists);
                if(null==result) {
                    System.out.println("Error Thrown!");
                }else if(result){
                    System.out.println("True");
                }else{
                    System.out.println("False");
                }
            }
        }
        System.out.println("Done framing linked lists");

    }

    private static Boolean doLinkedListIntersect(Collection<SinglyLinkedList> linkedLists) {
        Set<String> set = new HashSet<>();
        for(SinglyLinkedList linkedList : linkedLists) {
            Nodes temp = linkedList.head;
            //check if a cycle
            if(cycleDetected(temp)){
                return null;
            }
            while(null!=temp.next) {
                temp = temp.next;
            }
            if(set.contains(temp.val))
                return true;
            else
                set.add(temp.val);
        }
        return false;
    }

    private static boolean cycleDetected(Nodes temp)
    {
        Nodes slow = temp;
        Nodes fast = slow;
        while(null!=slow && null!=fast && null!=fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean addToLinkedList(Nodes srcNodes, Nodes destNodes)
    {
        Nodes temp = srcNodes;
        while(null!=temp.next) {
            temp = temp.next;
        }
        temp.next = destNodes;
        return true;
    }
}

class SinglyLinkedList {
    Nodes head;

    public SinglyLinkedList(Nodes head) {
        this.head = head;
    }
}

class Nodes
{
    String val;
    Nodes next;

    public Nodes(String val) {
        this.val = val;
    }
}
