import java.util.stream.IntStream;

class IsbnVerifier {

    private static final String ISBN_REGEX = "[0-9]{9}([0-9]|X)";

    boolean isValid(String stringToVerify) {
        String possibleIsbn = stringToVerify.replace("-", "");
        return possibleIsbn.matches(ISBN_REGEX)
                && getCheckValue(possibleIsbn.toCharArray()) == 0;
    }

    private int getCheckValue(char[] isbn) {
        int sum = IntStream.range(0, 10)
                .map(i -> (10 - i) * getValue(isbn[i]))
                .sum();
        return sum % 11;
    }

    private int getValue(char ch) {
        return Character.digit(ch, 10);
    }
}
