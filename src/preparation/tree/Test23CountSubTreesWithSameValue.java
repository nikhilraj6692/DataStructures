package preparation.tree;

import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test23CountSubTreesWithSameValue {
    public static void main(String[] args) {
        Node<Integer> node = TreeBuilder.buildTree7();
        System.out.println(countUnivalTrees(node));
    }

    /* Construct the following tree
                    1
                  /   \
                 2     3
               /     /   \
              4     5     6
            /     /   \     \
           4     5     5     7
       */
    private static int countUnivalTrees(Node root) {
        if (root == null) {
            return 0;
        }
        int count = countUnivalTrees(root.left) + countUnivalTrees(root.right);
        if (root.left != null && root.data != root.left.data) {
            return count;
        }

        if (root.right != null && root.data != root.right.data) {
            return count;
        }

        // if whole tree is unival tree
        return count + 1;
    }
}


