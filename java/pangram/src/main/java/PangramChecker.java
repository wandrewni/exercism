public class PangramChecker {

    private static String[] THE_ALPHABET = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                                            "n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public boolean isPangram(String input) {
        boolean containsAllLetters = true;
        for (String letter : THE_ALPHABET) {
            if (!input.toLowerCase().contains(letter)) {
                containsAllLetters = false;
                break;
            }
        }
        return containsAllLetters;
    }
}
