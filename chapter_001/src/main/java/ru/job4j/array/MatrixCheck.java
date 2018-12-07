package ru.job4j.array;


public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int rowAndColumnLength = data[0].length;
        boolean sampleForFirstDiagonal = data[0][0];
        boolean sampleForSecondDiagonal = data[0][rowAndColumnLength - 1];
        for (int i = 0; i < rowAndColumnLength; i++) {
            if (data[i][i] != sampleForFirstDiagonal) {
                result = false;
            }
            if (data[i][rowAndColumnLength - 1 - i] != sampleForSecondDiagonal) {
                result = false;
            }
        }
        return result;
    }
}
