public class HelloWorld {
    public static String hello(String name) {
        if (isBlank(name))
            return "Hello, World!";
        else
            return "Hello, " + name + "!";
    }

    private static boolean isBlank(String name) {
        return name == null || "".equals(name);
    }
}
