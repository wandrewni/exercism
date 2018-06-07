/**
 * Created by anicholson on 5/11/17.
 */
public class Acronym {
    private StringBuilder acronymBuilder = new StringBuilder();

    public Acronym(String phrase) {
        String[] split = phrase.split(" ");
        for (String word : split) {
            acronymBuilder.append(word.charAt(0));
            // messy!
            boolean foundLowercase = false;
            boolean foundHyphen = false;
            for (int i = 1; i < word.length(); i++) {
                if ((Character.isUpperCase(word.charAt(i)) && foundLowercase) || foundHyphen){
                    acronymBuilder.append(word.charAt(i));
                    foundLowercase = false;
                    foundHyphen = false;
                }

                if (Character.isLowerCase(word.charAt(i))){
                    foundLowercase = true;
                }
                if (word.charAt(i) == '-') {
                    foundHyphen = true;
                }
            }
        }
    }

    public String get() {
        return acronymBuilder.toString().toUpperCase();
    }
}
