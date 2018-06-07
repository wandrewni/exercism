public class Twofer {
    public String twofer(String name) {
        return "One for " + (null == name ? "you" : name) + ", one for me.";
    }
}