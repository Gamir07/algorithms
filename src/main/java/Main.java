import algorithm1.StringListImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> liist = new ArrayList<>();
        liist.clear();
        StringListImpl list = new StringListImpl(10);
        list.add("boy");
        list.add("girl");
        list.add("hello");
        list.add("java");
        list.add("ok");
        list.add("boy");
        list.add("hello");
        list.add("ok");
//
//        StringListImpl list2 = new StringListImpl(10);
//        list2.add("boy");
//        list2.add("girl");
//        list2.add("hello");
//        list2.add("java");
//        list2.add("ok");
//        list2.add("boy");
//        list2.add("hello");
//        list2.add("ok");
//        System.out.println(list.equals(list2));
//        System.out.println(list.remove("hello"));
//        System.out.println(list.get(1));
        list.clear();
//        System.out.println(list.size());
//        System.out.println(list.set(1,"good"));
        System.out.println(list.get(1));
//        System.out.println(list.remove(3));
//        System.out.println(list.add(2,"bad"));
//        System.out.println(list.size());
//
//        String[] array = list.toArray();
//        System.out.println(Arrays.toString(array));
    }
}