package after0602.q0616;

public class MyUser implements Comparable<MyUser>{

    private String id;
    private int age;

    public MyUser(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' + ", name=" + age;
    }

    @Override
    public int compareTo(MyUser o) {
        if (!(this.getAge() == o.getAge())) {
            return Integer.compare(this.getAge(), o.getAge());
        }else {
           return this.getId().compareTo(o.getId());
        }
    }
}
