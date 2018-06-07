public class Hamming {
    private final String strandA;
    private final String strandB;

    public Hamming(String strandA, String strandB) {
        if (strandA.length() != strandB.length())
            throw new IllegalArgumentException("Hamming distance only calculable for strands of the same length");
        this.strandA = strandA;
        this.strandB = strandB;
    }

    public int getHammingDistance() {
        int hammingDistance = 0;
        for (int i = 0; i < strandA.length(); i++) {
            if (strandA.charAt(i) != strandB.charAt(i))
                hammingDistance++;
        }
        return hammingDistance;
    }
}
