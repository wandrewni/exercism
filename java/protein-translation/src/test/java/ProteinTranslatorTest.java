import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProteinTranslatorTest {

    private static final String SERINE = "Serine";
    private static final String LEUCINE = "Leucine";
    private static final String PHENYLALANINE = "Phenylalanine";
    private static final String METHIONINE = "Methionine";
    private static final String TYROSINE = "Tyrosine";
    private static final String CYSTEINE = "Cysteine";
    private static final String TRYPTOPHAN = "Tryptophan";
    private ProteinTranslator proteinTranslator;

    @Before
    public void setUp() {
        proteinTranslator = new ProteinTranslator();
    }

    @Test
    public void testMethionineRnaSequence() {
        List<String> expected = Arrays.asList(METHIONINE);
        assertEquals(expected, proteinTranslator.translate("AUG"));
    }

    @Test
    public void testPhenylalanineRnaSequence1() {
        List<String> expected = Arrays.asList(PHENYLALANINE);
        assertEquals(expected, proteinTranslator.translate("UUU"));
    }

    @Test
    public void testPhenylalanineRnaSequence2() {
        List<String> expected = Arrays.asList(PHENYLALANINE);
        assertEquals(expected, proteinTranslator.translate("UUC"));
    }

    @Test
    public void testLeucineRnaSequence1() {
        List<String> expected = Arrays.asList(LEUCINE);
        assertEquals(expected, proteinTranslator.translate("UUA"));
    }

    @Test
    public void testLeucineRnaSequence2() {
        List<String> expected = Arrays.asList(LEUCINE);
        assertEquals(expected, proteinTranslator.translate("UUG"));
    }

    @Test
    public void testSerineRnaSequence1() {
        List<String> expected = Arrays.asList(SERINE);
        assertEquals(expected, proteinTranslator.translate("UCU"));
    }

    @Test
    public void testSerineRnaSequence2() {
        List<String> expected = Arrays.asList(SERINE);
        assertEquals(expected, proteinTranslator.translate("UCC"));
    }

    @Test
    public void testSerineRnaSequence3() {
        List<String> expected = Arrays.asList(SERINE);
        assertEquals(expected, proteinTranslator.translate("UCA"));
    }

    @Test
    public void testSerineRnaSequence4() {
        List<String> expected = Arrays.asList(SERINE);
        assertEquals(expected, proteinTranslator.translate("UCG"));
    }

    @Test
    public void testTyrosineRnaSequence1() {
        List<String> expected = Arrays.asList(TYROSINE);
        assertEquals(expected, proteinTranslator.translate("UAU"));
    }

    @Test
    public void testTyrosineRnaSequence2() {
        List<String> expected = Arrays.asList(TYROSINE);
        assertEquals(expected, proteinTranslator.translate("UAC"));
    }

    @Test
    public void testCysteineRnaSequence1() {
        List<String> expected = Arrays.asList(CYSTEINE);
        assertEquals(expected, proteinTranslator.translate("UGU"));
    }

    @Test
    public void testCysteineRnaSequence2() {
        List<String> expected = Arrays.asList(CYSTEINE);
        assertEquals(expected, proteinTranslator.translate("UGC"));
    }

    @Test
    public void testTryptophanRnaSequence1() {
        List<String> expected = Arrays.asList(TRYPTOPHAN);
        assertEquals(expected, proteinTranslator.translate("UGG"));
    }

    @Test
    public void testStopRnaSequence1() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, proteinTranslator.translate("UAA"));
    }

    @Test
    public void testStopRnaSequence2() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, proteinTranslator.translate("UAG"));
    }

    @Test
    public void testStopRnaSequence3() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, proteinTranslator.translate("UGA"));
    }

    @Test
    public void testTranslationOfRnaToProteinList() {
        List<String> expected = Arrays.asList(METHIONINE, PHENYLALANINE, TRYPTOPHAN);
        assertEquals(expected, proteinTranslator.translate("AUGUUUUGG"));
    }

    @Test
    public void testTranslationStopsIfStopCodonAtBeginning() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, proteinTranslator.translate("UAGUGG"));
    }

    @Test
    public void testTranslationStopsIfStopCodonAtEnd1() {
        List<String> expected = Arrays.asList(TRYPTOPHAN);
        assertEquals(expected, proteinTranslator.translate("UGGUAG"));
    }

    @Test
    public void testTranslationStopsIfStopCodonAtEnd2() {
        List<String> expected = Arrays.asList(METHIONINE, PHENYLALANINE);
        assertEquals(expected, proteinTranslator.translate("AUGUUUUAA"));
    }

    @Test
    public void testTranslationStopsIfStopCodonInMiddle1() {
        List<String> expected = Arrays.asList(TRYPTOPHAN);
        assertEquals(expected, proteinTranslator.translate("UGGUAGUGG"));
    }

    @Test
    public void testTranslationStopsIfStopCodonInMiddle2() {
        List<String> expected = Arrays.asList(TRYPTOPHAN, CYSTEINE, TYROSINE);
        assertEquals(expected, proteinTranslator.translate("UGGUGUUAUUAAUGGUUU"));
    }

    @Test
    public void testTranslationStopsIfStopCodonInMiddle3() {
        List<String> expected = Arrays.asList(TRYPTOPHAN, CYSTEINE, TYROSINE);
        assertEquals(expected, proteinTranslator.translate("UGGUGUUAUUGAUGGUUUUAA"));
    }

}
