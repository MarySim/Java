public class MyClass {
    // Публичные методы
    @Repeat(times = 2)
    public void publicMethod1(String message) {
        System.out.println("Публичный метод 1: " + message);
    }

    public void publicMethod2(int number) {
        System.out.println("Публичный метод 2: " + number);
    }

    // Защищенные методы
    @Repeat(times = 3)
    protected void protectedMethod1(String text, int count) {
        System.out.println("Защищенный метод 1: " + text + " (" + count + ")");
    }

    protected void protectedMethod2() {
        System.out.println("Защищенный метод 2");
    }

    // Приватные методы
    @Repeat(times = 1)
    private void privateMethod1(int a, int b) {
        System.out.println("Приватный метод 1: " + a + " + " + b + " = " + (a + b));
    }

    @Repeat(times = 2)
    private String privateMethod2(String name) {
        String result = "Привет, " + name + "!";
        System.out.println(result);
        return result;
    }

    private void privateMethod3() {
        System.out.println("Приватный метод 3 (без аннотации)");
    }
}