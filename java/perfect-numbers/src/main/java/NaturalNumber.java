class NaturalNumber {
    private int number;

    public NaturalNumber(int number) {
        if(number < 1)
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        this.number = number;
    }

    public Classification getClassification() {
        int sumOfFactors = 0;

        for (int i = number - 1; i > 0; i--)
            if (number % i == 0)
                sumOfFactors += i;

        if (sumOfFactors == number)
            return Classification.PERFECT;
        else if (sumOfFactors > number)
            return Classification.ABUNDANT;
        else
            return Classification.DEFICIENT;
    }
}
