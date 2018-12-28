package ru.job4j.array;


public class MatrixCheck {
    /**
     *
     * @param data входные данные.
     * @return возвращает true если элементы в диагоналях одинаковы.
     */
    public boolean mono(boolean[][] data) {
        /**
         * @param sample1 Элемент из первой диагонали для сравнения.
         * @param sample2 Элемент из второй диагонали для сравнения.
         */
        boolean result = true;
        int length = data[0].length;
        boolean sample1 = data[0][0];
        boolean sample2 = data[0][length - 1];
        for (int i = 0; i < length; i++) {
            if (data[i][i] != sample1) {
                result = false;
            }
            if (data[i][length - 1 - i] != sample2) {
                result = false;
            }
        }
        return result;
    }
}
