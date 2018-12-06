package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
public class BubbleSortTest {
    @Test
    public void whenSortArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arrayToSort = new int[] {4, 8, 7, 3, 2};
        int[] expected = new int[] {2, 3, 4, 7, 8};
        assertThat(bubbleSort.sort(arrayToSort), is(expected));
    }
}
