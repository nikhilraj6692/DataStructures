package preparation.tree;

public class test<T>
{

    private T t;

    public static void main(String[] args)
    {
        test obj = new test();
        obj.set("nik");
        obj.set(1);
        obj.set("%");
        System.out.print(obj.get());

    }

    private T get()
    {
        return t;
    }

    private void set(T nik)
    {
        this.t = nik;
    }
}
