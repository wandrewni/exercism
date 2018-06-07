class TwelveDays {

    private static final String[] NUMERICALS = new String[]{
            "first", "second", "third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth"
    };

    private static final String[] GIFTS = new String[]{
            "a Partridge in a Pear Tree",
            "two Turtle Doves",
            "three French Hens",
            "four Calling Birds",
            "five Gold Rings",
            "six Geese-a-Laying",
            "seven Swans-a-Swimming",
            "eight Maids-a-Milking",
            "nine Ladies Dancing",
            "ten Lords-a-Leaping",
            "eleven Pipers Piping",
            "twelve Drummers Drumming"
    };

    String verse(int verseNumber) {
        return getVerseStart(verseNumber) + appendGifts(verseNumber);
    }

    private String getVerseStart(int verseNumber) {
        return "On the " + NUMERICALS[verseNumber - 1] + " day of Christmas my true love gave to me, ";
    }

    private String appendGifts(int verseNumber) {
        StringBuilder builder = new StringBuilder();
        for (int i = verseNumber; i > 1; i--)
            builder.append(GIFTS[i - 1]).append(", ");
        if (verseNumber > 1)
            builder.append("and ");
        builder.append(GIFTS[0]).append(".\n");
        return builder.toString();
    }

    String verses(int startVerse, int endVerse) {
        final StringBuilder verses = new StringBuilder();
        for (int i = startVerse; i < endVerse; i++)
            verses.append(verse(i)).append("\n");
        return verses.append(verse(endVerse))
                .toString();
    }

    String sing() {
        return verses(1, NUMERICALS.length);
    }
}
