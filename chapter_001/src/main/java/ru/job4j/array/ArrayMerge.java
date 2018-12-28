package ru.job4j.array;

/**
 * Created by Lenovo on 12/27/2018.
 */
public class ArrayMerge {
    public int[] mergeSortedArrays(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (index1 < first.length && index2 < second.length) {
            if (first[index1] <= second[index2]) {
                result[index3] = first[index1];
                index1++;
                index3++;
            } else {
                result[index3] = second[index2];
                index2++;
                index3++;
            }
        }
        if (index1 == first.length) {
            System.arraycopy(second, index2, result, index3, second.length - index2);
        } else {
            System.arraycopy(first, index1, result, index3, first.length - index1);
        }
        return result;
    }
}
