import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Proverb {
    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words.length == 0)
            return "";
        else
            return makeBody() + makeConclusion();
    }

    private String makeBody() {
        String body = IntStream.range(1, words.length)
                .mapToObj(this::makeLine)
                .collect(joining(""));
        return body;
    }

    private String makeConclusion() {
        return "And all for the want of a " + words[0] + ".";
    }

    private String makeLine(int itemNumber) {
        final String lostObject = words[itemNumber];
        final String neededObject = words[itemNumber - 1];
        return "For want of a " + neededObject + " the " + lostObject + " was lost.\n";
    }

}
