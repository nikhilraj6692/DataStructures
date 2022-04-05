package preparation.generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test01OverrideAndEquals
{

    public static void main(String[] args)
    {
        MyClass first = new MyClass("a", "first");
        MyClass second = new MyClass("a", "first");
        System.out.println(first.equals(second));

        /*for normal objects, which donot implement Map, only equals will be used but for map,
        understand that if you override hashcode then you need to override equals because
        hashcode will give you bucket where both above elements stay and equals will search
        in those buckets...so, above will return false if you override hashcode and not equals
        but above will give true if you only override equals because hashing is not
        used here, meaning that equals will only work on important field*/

        /*
        here in hashset when you implement hashcode, ten each time you add something to map,
        firstly hashcode ic checked...if hashcode is same, then in the same entry it is
        checked that new entry is equal to any of the old entry or not with equals method. If it
        finds true, then it will not insert...in case of hashmap it will replace.
        If found false, then in the same bucket, there will be one more entry so the total count
        would be 2. If hashcode is commented, then default hashcode method will
        run in Object class and it will make two entries even if important field is same. Also,
        while adding element in hashmap, it checks if bucket size is 0. if o, then
        it will not call equals method otherwise it will check the bucket and compare elements in
         bucket with equals method. It will also make two entries if only hashcode
        is implemented because hashcode will verify that buckets are same but how will it find
        that both classes are same??? It will just try to check content (because
        equals method in String class checks content and for other classes it calls object class
        eqquals which checks address
        ...Note address is different and hashcode is different. Object class always checks for
        address locations. hashcode in Object class is native
        meaning that it is implemented in JVM. transient keyword does not serialize a field, it
        will also not show while inspecting variables...For hashmaps, hashcode is
        checked on key and equals also for key...in short, hashcode is checked with key in any
        hashing technique and value is only to set in case hashed value comes out to be
        same. Also note that compareto gives a value that the two strings are different at which
        index.(formula:
        firstString.charAt(i)-secondString.charAt(i)) where i is index at which characters are
        different
         */
        HashSet<MyClass> employees = new HashSet<>();
        employees.add(first);
        employees.add(second);
        System.out.println(employees.size());
        System.out.println(employees.contains(second));
        System.out.println("employee.hashCode():  " + first.hashCode()
            + "  employee2.hashCode():" + second.hashCode());

        Map<MyClass, Integer> map = new HashMap<>();
        map.put(first, 1);
        map.put(second, 2);
        System.out.println(map.size());
    }
}

class MyClass
{

    private final String importantField;
    private final String anotherField;

    public MyClass(final String equalField, final String anotherField)
    {
        this.importantField = equalField;
        this.anotherField = anotherField;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((importantField == null) ? 0 : importantField.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        return "MyClass{" +
            "importantField='" + importantField + '\'' +
            ", anotherField='" + anotherField + '\'' +
            '}';
    }
}
