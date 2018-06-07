public class LargestSeriesProductCalculator {
    private int[] digits;

    public LargestSeriesProductCalculator(String string) {
        validateInputString(string);
        initializeDigits(string);
    }

    public long calculateLargestProductForSeriesLength(int length) {
        validateSeriesLength(length);

        return calculateMaxProduct(length);
    }

    private void validateInputString(String string) {
        if (string == null)
            throw new IllegalArgumentException("String to search must be non-null.");
        if (! string.matches("[0-9]*"))
            throw new IllegalArgumentException("String to search may only contains digits.");
    }

    private void initializeDigits(String string) {
        digits = new int[string.length()];
        for (int i = 0; i < string.length(); i++)
            digits[i] = Integer.valueOf(string.substring(i, i+1));
    }

    private void validateSeriesLength(int length) {
        if (length > digits.length)
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        if (length < 0)
            throw new IllegalArgumentException("Series length must be non-negative.");
    }

    private long calculateMaxProduct(int length) {
        long maxProduct = 0;
        for (int i = 0; i < digits.length - (length - 1); i++) {
            long product = calcProduct(i,length);
            if (product > maxProduct)
                maxProduct = product;
        }
        return maxProduct;
    }


    private long calcProduct(int i, int length) {
        long product = 1;
        for (int j = 0; j < length; j++) {
            product *= digits[i+j];
        }
        return product;
    }
}
