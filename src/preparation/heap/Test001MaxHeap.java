package preparation.heap;

import java.util.Arrays;
import java.util.Date;

/*
The max heap is nothing but a complete binary tree with parent being max than its children and
 which can be arranged in the form of an array with parent node can be identified by (i-2)/n,
 where i is the index of an element and n is total size of an array.
To insert, add to the array and shift up. Shifting up means that check if the child is less than
its parent, then swap parent and child. Continue shifting up till max heap rule is broken

to extract max, replace max element(root) with last element of array and shift down. Shifting
down means that check if element is less than any of the children, if yes then swap and
continue shifting down till max heap rule is broken

Remove is making element to getMaxElement+1, shifting up and extracting max (remove top and
shift down)
 */
public class Test001MaxHeap
{

    private static int size = -1;
    private static int[] arr = new int[50];

    public static void main(String[] args)
    {
        insert(45);
        insert(20);
        insert(14);
        insert(12);
        insert(31);
        insert(7);
        insert(11);
        insert(13);
        insert(7);

        System.out.print("Priority queue :: ");
        
        Arrays.stream(arr).forEach(x->System.out.print(x+ " "));

        System.out.println();

        // Node with maximum priority
        System.out.print("Node with maximum priority : " +
            extractMax() + "\n");

        // Priority queue after extracting max
        System.out.print("Priority queue after " +
            "extracting maximum : ");
        
        Arrays.stream(arr).forEach(x->System.out.print(x+ " "));
    }

    private static int extractMax()
    {
        int max = arr[0];
        arr[0] = arr[size];
        size = size-1;

        shiftDown(0);
        return max;

    }

    private static void shiftDown(int parentPos)
    {
        int leftChildPos = findLeftChild(parentPos);
        int rightChildPos = findRightChild(parentPos);
        int maxIndex;
        if(arr[leftChildPos] > arr[rightChildPos]) {
            maxIndex = leftChildPos;
        } else {
            maxIndex = rightChildPos;
        }

        while(maxIndex <=size && arr[maxIndex] > arr[parentPos]) {
            if(arr[leftChildPos] > arr[rightChildPos]) {
                swap(leftChildPos, parentPos);
                parentPos = leftChildPos;
                leftChildPos = findLeftChild(parentPos);
                rightChildPos = findRightChild(parentPos);
                if(arr[leftChildPos] > arr[rightChildPos]) {
                    maxIndex = leftChildPos;
                } else {
                    maxIndex = rightChildPos;
                }
            } else {
                swap(rightChildPos, parentPos);
                parentPos = rightChildPos;
                leftChildPos = findLeftChild(parentPos);
                rightChildPos = findRightChild(parentPos);
                if(arr[leftChildPos] > arr[rightChildPos]) {
                    maxIndex = leftChildPos;
                } else {
                    maxIndex = rightChildPos;
                }
            }

        }
    }

    private static int findLeftChild(int parentPos)
    {
        return parentPos*2+1;
    }

    private static int findRightChild(int parentPos)
    {
        return parentPos*2+2;
    }

    public static void insert(int value) {
        arr[++size] = value;
        shiftUp(size);
    }

    private static void shiftUp(int childPosition)
    {
        int parentPos = findParentPos(childPosition);

        while(childPosition > 0 && arr[parentPos] < arr[childPosition]) {
            swap(parentPos, childPosition);

            childPosition = parentPos;
            parentPos = findParentPos(childPosition);
        }
    }

    private static int findParentPos(int childPosition)
    {
        return (childPosition-1)/2;
    }

    private static void swap(int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
