package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String sequence;

    public ReversedSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        char[] chars = sequence.toCharArray();
        String result = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            result += chars[i];
        }
        return result;
    }

    @Override
    public String subSequence(int subSequenceBegining, int subSequenceEnding) {
        String reversedSequence = sequence.toString();
        char[] chars = reversedSequence.toCharArray();
        String result = "";

        for (int i = subSequenceBegining; i < subSequenceEnding; i++) {
            result += chars[i];
        }
        return result;
    }

    @Override
    public char charAt(int index) {
        char[] chars = sequence.toString().toCharArray();
        return chars[index];
    }

    @Override
    public int length() {
        return sequence.length();
    }
}
// END
