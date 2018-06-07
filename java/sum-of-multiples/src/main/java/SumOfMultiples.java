public class SumOfMultiples {
    private int sum = 0;

    public SumOfMultiples(int limit, int[] multiples) {
        for (int i = 0; i < limit; i++) {
            boolean isMultiple = false;
            for (int j = 0; j < multiples.length; j++) {
                if (i % multiples[j] == 0){
                    isMultiple = true;
                }
            }
            if(isMultiple)
                sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}
