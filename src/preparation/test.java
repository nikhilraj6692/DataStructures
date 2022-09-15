package preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class test
{

    public static void main(String[] args)
    {
        A a  = new A();
        try{
            a.divide(10,0);
        }catch(Exception e){
            System.out.println("exception");
        }


        Collection<String> coll = new ArrayList<>();
        List<Integer> list = Arrays.asList(1,2,3);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }

    public static void main(char args[]){
        System.out.println('a');
    }
}

class A{
    public int divide(int a, int b){
        try{
            return a/b;
        }finally
        {
            System.out.println("finally");
        }
    }
}


