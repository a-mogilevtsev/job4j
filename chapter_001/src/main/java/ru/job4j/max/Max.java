package ru.job4j.max;


public class Max {
    /**
     * Находит максимум двух чисел.
     * @param first, second числа для нахождения максимального.
     * @return Максимальное из двух чисел.
     */

    public int max(int first, int second) {
        return (first >= second ? first : second);
    }

    public int max(int first, int second, int third) {
        int temp = max(first, second);
        return max(temp, third);
    }
}
