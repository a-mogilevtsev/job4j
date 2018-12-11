package ru.job4j.array;

public class Square {
    /**
     *
     * @param bound - размер массива.
     * @return - возвращает массив с числами от 1 до bound возведенными в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i != bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}
