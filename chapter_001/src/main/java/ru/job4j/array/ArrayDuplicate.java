package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     *
     * @param array входящий массив строк.
     * @return возвращает массив строк с удалёнными дубликатами.
     */
    public String[] remove(String[] array) {
        int countRemovedEl = 0; //количество элементов массива подлежащих удалению;
        for (int i = 0; i < array.length - countRemovedEl; i++) {
            String currentString = array[i];
                for (int j = i + 1; j < array.length - countRemovedEl; j++) {
                    if (currentString.equals(array[j])) {
                        array[j] = array[array.length - 1 - countRemovedEl];
                        array[array.length - 1 - countRemovedEl] = currentString;
                        countRemovedEl++;
                        i--;
                    }
                }
        }
        return Arrays.copyOf(array, array.length - countRemovedEl);
    }
}
