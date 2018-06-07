/**
 * Created by anicholson on 5/14/17.
 */
public class LuhnValidator {
    public boolean isValid(String inputNumber) {
        String cleanedNumber = removeWhitespace(inputNumber);
        if (cleanedNumber.length() <= 1 || !cleanedNumber.matches("[0-9]+"))
            return false;
        else
            return isLuhnValid(cleanedNumber);
    }

    private boolean isLuhnValid(String inputNumber) {
        int[] intArray = toIntArray(inputNumber);

        applyDoublingRule(intArray);

        return sumArray(intArray) % 10 == 0;
    }

    // rule is applied to every other number, starting from the end of the array
    private void applyDoublingRule(int[] intArray) {
        for (int i = intArray.length - 2; i > -1; i = i - 2) {
            intArray[i] = applyDoublingRule(intArray[i]);
        }
    }

    private String removeWhitespace(String inputNumber) {
        return inputNumber.replaceAll("\\s", "");
    }

    private int[] toIntArray(String cleanedNumber) {
        int[] intArray = new int[cleanedNumber.length()];
        for (int i = intArray.length - 1; i > -1; i--) {
            intArray[i] = toInt(cleanedNumber.charAt(i));
        }
        return intArray;
    }

    private int applyDoublingRule(int digit) {
        int value = digit + digit;
        if (value > 9)
            value = value - 9;
        return value;
    }

    private int sumArray(int[] intArray) {
        int sum = 0;
        for (int i : intArray) {
            sum += i;
        }
        return sum;
    }

    private int toInt(char c) {
        return Integer.valueOf(String.valueOf(c));
    }

}