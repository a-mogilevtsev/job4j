package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     *
     * @param array входящий массив строк.
     * @return возвращает массив строк с удалёнными дубликатами.
     */
    public String[] remove(String[] array) {
        int count = 0; //количество элементов массива подлежащих удалению;
        for (int i = 0; i < array.length - count; i++) {
            String string = array[i];
                for (int j = i + 1; j < array.length - count; j++) {
                    if (string.equals(array[j])) {
                        array[j] = array[array.length - 1 - count];
                        array[array.length - 1 - count] = string;
                        count++;
                        i--;
                    }
                }
        }
        return Arrays.copyOf(array, array.length - count);
    }
}
