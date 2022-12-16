package list;

import list.arrayList.SelfArrayList;
import list.linkedList.SelfLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListRunner {
    public static void main(String[] args) {

        List<Object> l = new ArrayList<>();

        var eugen = new User("Eugen");
        var eugen1 = new User("1Eugen1");

        SelfList<User> list = new SelfArrayList<>();
        list.add(new User("Romen"));
        list.add(new User("Den"));
        list.add(eugen);
        list.add(eugen1);
        list.add(new User("2Eugen2"));
        list.add(new User("3Eugen3"));
        list.add(new User("4Eugen4"));
        list.add(new User("5Eugen5"));
        list.add(new User("6Eugen5"));
        list.add(new User("6Eugen7"));
        list.add(new User("6Eugen8"));
        list.add(new User("6Eugen9"));
        list.add(new User("6Eugen0"));
        list.add(new User("6Eugen1"));
        list.add(new User("6Eugen2"));
        list.add(new User("6Eugen3"));
        list.add(new User("6Eugen4"));
        list.add(new User("7Eugen6"));
        list.add(new User("8Eugen5"));
        list.add(new User("9Eugen5"));
        list.add(new User("0Eugen5"));
        list.add(new User("1Eugen5"));
        list.add(new User("2Eugen5"));

        System.out.println("-------------");
//        list.remove(eugen);
//        int indexEugen1 = list.indexOf(eugen1);
//        System.out.println(list.get(indexEugen1));
//        System.out.println(list.remove(indexEugen1));


        System.out.println(list);

    }
}
