/**
 * Created by anicholson on 5/13/17.
 */
public class RaindropConverter {
    public String convert(int inputNumber) {
        String converted = "";
        boolean shouldConvert = false;
        if (inputNumber % 3 == 0) {
            converted += "Pling";
            shouldConvert = true;
        }

        if (inputNumber % 5 == 0) {
            converted += "Plang";
            shouldConvert = true;
        }

        if (inputNumber % 7 == 0) {
            converted += "Plong";
            shouldConvert = true;
        }

        if (shouldConvert)
            return converted;
        else
            return String.valueOf(inputNumber);
    }
}
