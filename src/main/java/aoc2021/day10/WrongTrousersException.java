package aoc2021.day10;

public class WrongTrousersException extends Exception {
    private char wrongCharacter;

    public WrongTrousersException(char character) {
        this.wrongCharacter = character;
    }

    public long getScore() {
        switch (wrongCharacter) {
            case ')':
                return 3;
            case ']':
                return 57;
            case '}':
                return 1197;
            case '>':
                return 25137;
            default:
                throw new UnsupportedOperationException("Unknown: " + wrongCharacter);
        }
    }
}
