package q0514;

public class TestEnum {

    public static final TestEnum MONDAY= new TestEnum(1);
    public static final TestEnum TUESDAY = new TestEnum(2);
    public static final TestEnum WEDNESDAY = new TestEnum(3);
    public static final TestEnum THURSDAY = new TestEnum(4);
    public static final TestEnum FRIDAY = new TestEnum(5);
    public static final TestEnum SATURDAY = new TestEnum(6);
    public static final TestEnum SUNDAY = new TestEnum(7);
    public static final TestEnum DEFAULT= new TestEnum(-1);

    private final int num;

    private TestEnum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "TestEnum{" +
                "num=" + num +
                '}';
    }


}
