package after0602.q0618;

public class Member implements Comparable<Member>{

    private String name;
    private String id;
    private Integer age;

    public Member(String name, String id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member[age=" + age + "]";
    }

    @Override
    public int compareTo(Member o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}
