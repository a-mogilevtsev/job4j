package ru.job4j.array;


public class Turn {
    public int[] back(int[] array) {
        for (int iterNum = 0; iterNum < array.length / 2; iterNum++) {
            int temp = array[iterNum];
            array[iterNum] = array[array.length - iterNum - 1];
            array[array.length - iterNum - 1] = temp;
        }
        return array;
    }
}
