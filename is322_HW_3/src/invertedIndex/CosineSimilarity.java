import java.util.*;

public class CosineSimilarity {

    private static class Values {
        private int val1;
        private int val2;

        private Values(int v1, int v2) {
            this.val1 = v1;
            this.val2 = v2;
        }

        public void updateValues(int v1, int v2) {
            this.val1 = v1;
            this.val2 = v2;
        }
    }

    public double score(String T1, String T2) {
        String[] doc1Words = T1.split(" ");
        String[] doc2Words = T2.split(" ");
        Map<String, Values> wordFreqVector = new HashMap<>();
        List<String> distinctWords = new ArrayList<>();

        prepareWordFrequency(doc1Words, wordFreqVector, distinctWords, 1, 0);
        prepareWordFrequency(doc2Words, wordFreqVector, distinctWords, 0, 1);

        double vectAB = 0.0;
        double vectA = 0.0;
        double vectB = 0.0;
        for (String word : distinctWords) {
            Values vals = wordFreqVector.get(word);
            double freq1 = vals.val1;
            double freq2 = vals.val2;
            vectAB += freq1 * freq2;
            vectA += freq1 * freq1;
            vectB += freq2 * freq2;
        }

        return vectAB / (Math.sqrt(vectA) * Math.sqrt(vectB));
    }

    private void prepareWordFrequency(String[] words, Map<String, Values> wordFreqVector, List<String> distinctWords,
                                      int freq1Value, int freq2Value) {
        for (String text : words) {
            String word = text.trim();
            if (!word.isEmpty()) {
                if (wordFreqVector.containsKey(word)) {
                    Values vals = wordFreqVector.get(word);
                    int freq1 = vals.val1 + freq1Value;
                    int freq2 = vals.val2 + freq2Value;
                    vals.updateValues(freq1, freq2);
                    wordFreqVector.put(word, vals);
                } else {
                    Values vals = new Values(freq1Value, freq2Value);
                    wordFreqVector.put(word, vals);
                    distinctWords.add(word);
                }
            }
        }
    }


public void calculateCosineSimilarityScores(List<String> texts, String query, int k) {
    CosineSimilarity cs = new CosineSimilarity();
    List<ScoredText> scoredTexts = new ArrayList<>();

    // Calculate cosine similarity scores for each text
    for (int i = 0; i < texts.size(); i++) {
        double score = cs.score(query, texts.get(i));
        scoredTexts.add(new ScoredText(i + 1, score));
    }

    // Sort the scored texts based on the score in descending order
    Collections.sort(scoredTexts, Comparator.comparing(ScoredText::getScore).reversed());

    // Print the top k scored texts
    System.out.println("Top " + k + " Cosine Similarity Scores: ");
    for (int i = 0; i < k && i < scoredTexts.size(); i++) {
        ScoredText scoredText = scoredTexts.get(i);
        System.out.println("File " + scoredText.getFileNumber() + ": " + scoredText.getScore());
    }
}
}