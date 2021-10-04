package preparation.tree;

import preparation.util.Node;

import java.util.HashMap;
import java.util.Map;

public class Test22PrintTreeFromArray {
    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 2, 2, 4, 4};

        Node root = createTree(parent);
        Test01InorderTraversal.inOrderTraversal(root);
    }

    private static Node createTree(int[] parent) {
        Node root = null;
        Map<Integer, Node<Integer>> map =new HashMap<>();

        for(int i=0; i<parent.length; i++){
            map.put(i, new Node(i));
        }

        for(int i=0;i<parent.length;i++){
            if(parent[i] == -1) {
                root = map.get(i);
            }else{
                if(map.get(parent[i]).left==null){
                    map.get(parent[i]).left = map.get(i);
                }else{
                    map.get(parent[i]).right = map.get(i);
                }
            }
        }
        return root;
    }
}
