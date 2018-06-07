public class RnaTranscription {
    public String ofDna(String dnaString) {
        StringBuilder transcribed = new StringBuilder(dnaString.length());
        for (int i = 0; i < dnaString.length(); i++) {
            char c = dnaString.charAt(i);
            transcribed.append(transcribeLetter(c));
        }
        return transcribed.toString();
    }

    private String transcribeLetter(char letter) {
        switch (letter) {
            case 'C':
                return "G";
            case 'G':
                return "C";
            case 'T':
                return "A";
            case 'A':
                return "U";
            default:
                return "";
        }
    }

}