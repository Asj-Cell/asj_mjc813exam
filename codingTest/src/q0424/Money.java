package q0424;

public enum Money {
   WON("won"),
   TEN("ten");

    private final String unit;

    Money(String unit) {
        this.unit=unit;
    }
}
