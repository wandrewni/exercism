import java.util.*;

import static java.util.Arrays.asList;

class ProteinTranslator {
    private static final Map<String, String> CODONS_TO_NAMES = new HashMap<>();
    private static final String METHIONINE = "Methionine";
    private static final String PHENYLALANINE = "Phenylalanine";
    private static final String LEUCINE = "Leucine";
    private static final String SERINE = "Serine";
    private static final String TYROSINE = "Tyrosine";
    private static final String CYSTEINE = "Cysteine";
    private static final String TRYPTOPHAN = "Tryptophan";
    private static final List<String> STOP_CODONS = asList("UAA", "UAG", "UGA");
    private static final int CODON_LENGTH = 3;

    static {
        CODONS_TO_NAMES.put("AUG", METHIONINE);
        CODONS_TO_NAMES.put("UUU", PHENYLALANINE);
        CODONS_TO_NAMES.put("UUA", LEUCINE);
        CODONS_TO_NAMES.put("UUC", PHENYLALANINE);
        CODONS_TO_NAMES.put("UUG", LEUCINE);
        CODONS_TO_NAMES.put("UCA", SERINE);
        CODONS_TO_NAMES.put("UCC", SERINE);
        CODONS_TO_NAMES.put("UCG", SERINE);
        CODONS_TO_NAMES.put("UCU", SERINE);
        CODONS_TO_NAMES.put("UAU", TYROSINE);
        CODONS_TO_NAMES.put("UAC", TYROSINE);
        CODONS_TO_NAMES.put("UGU", CYSTEINE);
        CODONS_TO_NAMES.put("UGC", CYSTEINE);
        CODONS_TO_NAMES.put("UGG", TRYPTOPHAN);
    }

    List<String> translate(String rnaSequence) {
        List<String> proteins = new ArrayList<>();
        for (int i = 0; i < getStopIndex(rnaSequence); i+= CODON_LENGTH) {
            final String codon = rnaSequence.substring(i, i + CODON_LENGTH);
            proteins.add(CODONS_TO_NAMES.get(codon));
        }
        return proteins;
    }

    private int getStopIndex(String rnaSequence) {
        final OptionalInt firstStopCodonIndex = STOP_CODONS.stream()
                .filter(rnaSequence::contains)
                .mapToInt(rnaSequence::indexOf)
                .min();
        return firstStopCodonIndex.orElse(rnaSequence.length());
    }

}