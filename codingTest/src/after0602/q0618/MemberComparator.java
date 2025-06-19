package after0602.q0618;

import java.util.Comparator;

public class MemberComparator implements Comparator<Member> {


    @Override
    public int compare(Member o1, Member o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
