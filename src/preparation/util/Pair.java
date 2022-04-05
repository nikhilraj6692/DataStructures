package preparation.util;

public class Pair<U, V>
{

    public final U first;       // first field of a pair
    public final V second;      // second field of a pair

    // Constructs a new preparation.tree.Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    // Factory method for creating a Typed preparation.tree.Pair immutable instance
    public static <U, V> Pair<U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }

    public U getFirst()
    {
        return first;
    }

    public V getSecond()
    {
        return second;
    }
}
