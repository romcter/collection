package list;

import list.linkedList.SelfLinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListRunner {
    public static void main(String[] args) {

        List<Object> l = new LinkedList<>();

        var eugen = new User("Eugen");
        var eugen1 = new User("1Eugen1");

        SelfList<User> list = new SelfLinkedList<>();
        list.add(new User("Romen"));
        list.add(new User("Den"));
        list.add(eugen);
        list.add(eugen1);
        list.add(new User("2Eugen2"));
        list.add(new User("3Eugen3"));
        list.add(new User("4Eugen4"));
        list.add(new User("5Eugen5"));

        System.out.println("-----Remove by object------");
        list.remove(eugen);
        int indexEugen1 = list.indexOf(eugen1);
        System.out.println(list.get(indexEugen1));
        System.out.println(list.remove(indexEugen1));


        System.out.println(list);

    }
}
