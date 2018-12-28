package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lenovo on 12/27/2018.
 */
public class ArrayMergeTest {
    @Test
    public void whenMergeArraysThenSortedArray() {
        ArrayMerge arrayMerger = new ArrayMerge();
        int[] first = {1, 3, 5, 7};
        int[] second = {2, 3, 4, 6};
        int[] expected = {1, 2, 3, 3, 4, 5, 6, 7};
        int[] result = arrayMerger.mergeSortedArrays(first, second);
        assertThat(result, is(expected));
    }

    public void whenMergeArraysWithDifferentLengthThenSortedArray() {
        ArrayMerge arrayMerger = new ArrayMerge();
        int[] first = {1, 3, 5, 7, 9, 10, 11};
        int[] second = {2, 3, 4, 6};
        int[] expected = {1, 2, 3, 3, 4, 5, 6, 7, 9, 10, 11};
        int[] result = arrayMerger.mergeSortedArrays(first, second);
        assertThat(result, is(expected));
    }

    public void whenMergeArraysWithDuplicatesThenSortedArray() {
        ArrayMerge arrayMerger = new ArrayMerge();
        int[] first = {1, 3, 5, 7};
        int[] second = {5, 5};
        int[] expected = {1, 3, 5, 5, 5, 7};
        int[] result = arrayMerger.mergeSortedArrays(first, second);
        assertThat(result, is(expected));
    }

    public void whenMergeArraysAndSecondBiggerThenSortedArray() {
        ArrayMerge arrayMerger = new ArrayMerge();
        int[] first = {1, 3, 5, 7, 8};
        int[] second = {2, 3, 4, 6, 9, 10};
        int[] expected = {1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = arrayMerger.mergeSortedArrays(first, second);
        assertThat(result, is(expected));
    }
}
