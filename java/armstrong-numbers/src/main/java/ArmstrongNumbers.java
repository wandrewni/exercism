import java.util.stream.IntStream;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
	    String numberString = String.valueOf(numberToCheck);
        return getTestValue(numberString.toCharArray()) == numberToCheck;
	}

    private int getTestValue(char[] digitArray) {
        final int numberOfDigits = digitArray.length;
        return IntStream.range(0, numberOfDigits)
                .mapToObj(i -> getDigit(digitArray[i]))
                .map(digit -> (int)Math.pow(digit, numberOfDigits))
        .reduce(0, (a, b) -> a + b);
    }

    private int getDigit(char digitChar) {
        final String digitString = String.valueOf(digitChar);
        return Integer.parseInt(digitString);
    }

}
