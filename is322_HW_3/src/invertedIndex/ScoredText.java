class ScoredText {
    private int fileNumber;
    private double score;

    public ScoredText(int fileNumber, double score) {
        this.fileNumber = fileNumber;
        this.score = score;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public double getScore() {
        return score;
    }
}