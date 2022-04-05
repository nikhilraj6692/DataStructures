package preparation.list;

public class Test53CustomHashMapImplementation
{

    public static void main(String[] args)
    {
        /*
        As we know that hashmap is an array of linked list, where linked list is represented by
        Entry, so we are going
        to create array to Entry<K,v> in short
         */
        CustomHashMap<Integer, String> map = new CustomHashMap<Integer, String>();
        System.out.println("Going to add entries in map");
        map.put(null, "Nothing");
        map.put(1, "ETC");
        map.put(2, "John");
        System.out.println("Displaying all the entry in map");
        map.display();
        System.out.println("Removing the entry with key 2");
        map.remove(2);
        map.display();
        System.out.println("Adding duplicate key 1 in map");
        map.put(1, "CSE");
        map.put(2, "John again");
        System.out.println("Displaying all the entry in map again");
        map.display();
        System.out.println("Adding entry with key 17 in map");
        map.put(17, "CS");
        map.display();

    }
}

class CustomHashMap<K, V>
{

    private Entry<K, V>[] buckets;
    private int capacity;
    private int size = 0;

    CustomHashMap(int capacity)
    {
        this.capacity = capacity;
        this.buckets = new Entry[capacity];
    }

    CustomHashMap()
    {
        this.capacity = 16;
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V val)
    {
        int index = -1;
        if (key == null)
        {
            index = 0;
        } else
        {
            index = key.hashCode() % (capacity);
        }

        Entry<K, V> entry = new Entry<>(key, val);
        Entry<K, V> previousEntry = null;

        //no element in bucket till now
        if (buckets[index] == null)
        {
            buckets[index] = entry;
            size++;
        } else
        {
            Entry<K, V> currentEntry = buckets[index];
            while (null != currentEntry)
            {
                if (currentEntry.key.equals(key))
                {
                    currentEntry.val = val;
                    return;
                } else
                {
                    previousEntry = currentEntry;
                    currentEntry = currentEntry.next;
                }
            }
            previousEntry.next = entry;
            size++;
        }
    }

    public void remove(K key)
    {
        int index = key.hashCode() % (capacity);
        Entry<K, V> currentNode = buckets[index];
        Entry<K, V> previousNode = null;

        while (null != currentNode)
        {
            if (currentNode.key.equals(key))
            {
                size--;
                if (previousNode == null)
                {
                    buckets[index] = currentNode.next;
                    return;
                } else
                {
                    previousNode.next = currentNode.next;
                    return;
                }
            } else
            {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }

    }

    public void display()
    {
        for (int i = 0; i < buckets.length; i++)
        {
            if (null != buckets[i])
            {
                Entry<K, V> current = buckets[i];
                while (null != current)
                {
                    System.out.print("(" + current.key + "," + current.val + "), ");
                    current = current.next;
                }
            }
        }

        System.out.println("\nThe size of the map : " + this.size);
    }
}

class Entry<K, V>
{

    Entry<K, V> next;
    K key;
    V val;

    Entry(K key, V val)
    {
        this.next = null;
        this.key = key;
        this.val = val;
    }

}
