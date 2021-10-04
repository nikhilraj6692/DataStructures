package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

import java.util.*;

public class Test17PrintPathToLeafNodes {
    public static void main(String[] args) {
        Node<Integer> root = TreeBuilder.buildTree6();

        printPathToTheLeafNodes(root);

        printPathToTheLeafNodesIterative(root);
    }

    private static void printPathToTheLeafNodesIterative(Node<Integer> root) {
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        Node<Integer> temp = null;

        Map<Node<Integer>, Node<Integer>> map = new HashMap<>();
        map.put(root, null);
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp.left == null && temp.right == null){
                printIterative(map, temp);
            }

            if(temp.right!=null){
                stack.push(temp.right);
                map.put(temp.right, temp);
            }

            if(temp.left!=null){
                stack.push(temp.left);
                map.put(temp.left, temp);
            }

        }
    }

    private static void printIterative(Map<Node<Integer>,Node<Integer>> map, Node<Integer> temp) {
        Node<Integer> parentNode = null;
        System.out.print(temp.data);
        while(true){
            parentNode = map.get(temp);
            if(parentNode != null){
                System.out.print("->" + parentNode.data);
                temp = parentNode;
            }else{
                break;
            }
        }

        System.out.println();
    }

    private static void printPathToTheLeafNodes(Node<Integer> root) {
        List<Integer> list = new ArrayList<>();
        findPath(root, list);
    }

    private static void findPath(Node<Integer> root, List<Integer> list) {
        if(root==null)
            return;
        if(root!=null){
            list.add(root.data);

            if(root.left!=null){
                findPath(root.left, list);
            }
            if(root.right!=null){
                findPath(root.right, list);
            }

            if(root.left == null && root.right == null){
                list.stream().forEach(e->System.out.print(e + " "));
                System.out.println();
            }
            list.remove(list.size()-1);
        }
    }

}
