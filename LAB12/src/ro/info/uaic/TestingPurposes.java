package ro.info.uaic;

public class TestingPurposes {

    private String stringField;
    private int intField;

    @Test
    public static void m1(int a, int b) {
    }

    public static void m2() {
    }

    @Test
    public static void m3(String a) {
        throw new RuntimeException("KaBoooom!");
    }

    public static void m4() {
    }

    @Test
    public static void m5() {
    }

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("Yiipekiyay");
    }

    public static void m8() {
    }

}
