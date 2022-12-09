package list;

import list.linkedList.SelfLinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LinkedListRunner {
    public static void main(String[] args) {

        List l = new LinkedList<>();


        SelfList<User> list = new SelfLinkedList<>();
        list.add(new User("Romen"));
        list.add(new User("Den"));
        var eugen = new User("Eugen");
        list.add(eugen);
        list.add(new User("1Eugen1"));
        list.add(new User("2Eugen2"));
        list.add(new User("3Eugen3"));

//        list.remove(new User("Den"));
//        list.remove(eugen);

        System.out.println(list);

    }

    static class User {
        private String username;

        User(String username) {
            this.username = username;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(username, user.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username);
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    '}';
        }
    }
}
