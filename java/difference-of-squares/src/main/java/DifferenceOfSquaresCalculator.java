public final class DifferenceOfSquaresCalculator {


    public int computeSquareOfSumTo(int input) {
        int sum = 0;
        for (int i = 1; i <= input; i++) {
            sum += i;
        }
        return square(sum);
    }

    private int square(int sum) {
        return (int)(Math.pow(sum,2.0));
    }

    public int computeSumOfSquaresTo(int input) {
        int squaredSum = 0;
        for (int i = 1; i <= input; i++) {
            squaredSum += square(i);
        }
        return squaredSum;
    }

    public int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input)-computeSumOfSquaresTo(input);
    }
}
