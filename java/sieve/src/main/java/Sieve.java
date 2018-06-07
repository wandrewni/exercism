import java.util.ArrayList;
import java.util.List;

class Sieve {
    private List<Integer> primeList = new ArrayList<>();
    private boolean[] possiblePrimes;

    Sieve(int maxPrime) {
        initializePrimesArray(maxPrime);
        findPrimesUpToMax();
    }

    private void initializePrimesArray(int maxPrime) {
        possiblePrimes = new boolean[maxPrime + 1];
        for (int i = 2; i < possiblePrimes.length; i++)
            possiblePrimes[i] = true;
    }

    private void findPrimesUpToMax() {
        for (int i = 0; i < possiblePrimes.length; i++)
            if (possiblePrimes[i]) {
                primeList.add(i);
                crossOutMultiples(i);
            }
    }

    private void crossOutMultiples(int prime) {
        for (int j = 2 * prime; j < possiblePrimes.length; j += prime)
            possiblePrimes[j] = false;
    }


    List<Integer> getPrimes() {
        return primeList;
    }
}
