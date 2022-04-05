package preparation.bst;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import preparation.tree.Test01InorderTraversal;
import preparation.util.Node;
import preparation.util.TreeBuilder;

public class Test11ConstructBSTFromTreeWithoutChangingStructure
{

    public static void main(String[] args)
    {
        Node<Integer> root = TreeBuilder.buildTree17();

        //first do inorder and create an ordered set and then replace the elements in the tree by
        // iterating through the set
        Set<Integer> set = new TreeSet<>();
        doInorderAndAddKeysToSetInAscendingOrder(root, set);

        replaceElementsWithSet(root, set.iterator());
        Test01InorderTraversal.inOrderTraversal(root);

    }

    private static void replaceElementsWithSet(Node<Integer> root, Iterator<Integer> setItr)
    {
        if (root == null)
        {
            return;
        }
        replaceElementsWithSet(root.left, setItr);
        root.data = setItr.next();
        replaceElementsWithSet(root.right, setItr);
    }

    private static void doInorderAndAddKeysToSetInAscendingOrder(Node<Integer> root,
        Set<Integer> set)
    {
        if (root == null)
        {
            return;
        }
        doInorderAndAddKeysToSetInAscendingOrder(root.left, set);
        set.add(root.data);
        doInorderAndAddKeysToSetInAscendingOrder(root.right, set);
    }
}
