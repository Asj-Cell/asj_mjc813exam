package after0602.q0619;

import after0602.q0618.Member;
import after0602.q0618.MemberComparator;
import after0602.q0618.ThreadUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static after0602.q0618.ThreadUtil.log;

public class CollectionMain {
    public static void main(String[] args) {
        TreeMap<Member, String> tm = new TreeMap<>(new MemberComparator());
        for (int i = 5; i > 0; i--) {
            Member member = new Member("name" + i, "id"+i, 10 + i);
            tm.put(member, "member" + i);
        }
        System.out.println(tm);


    }

    private static void setTest(Set<Integer> set, int count) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            set.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("걸린 시간: "+(endTime-startTime)+"ms");
    }
}
