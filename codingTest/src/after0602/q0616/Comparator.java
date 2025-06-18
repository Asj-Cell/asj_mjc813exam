package after0602.q0616;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

    public static void main(String[] args) {

        List<MyUser> userList = new ArrayList<>();
        userList.add(new MyUser("id1", 10));
        userList.add(new MyUser("id2", 800));
        userList.add(new MyUser("id3", 100));
        userList.add(new MyUser("id4", 560));
        userList.add(new MyUser("id5", 560));

        userList.sort(null);
        System.out.println(userList);
    }
}
