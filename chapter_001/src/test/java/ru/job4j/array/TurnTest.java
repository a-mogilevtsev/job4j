package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TurnTest {
    @Test
    public void whenElementNumberIsEven() {
        Turn arrayTurner = new Turn();
        int[] arrayToTurn = new int[] {1, 2, 3, 4, 5};
        int[] expected = new int[] {5, 4, 3, 2, 1};
        assertThat(arrayTurner.back(arrayToTurn), is(expected));
    }

    @Test
    public void whenElementNumberIsOdd() {
        Turn arrayTurner = new Turn();
        int[] arrayToTurn = new int[] {1, 2, 3, 4, 5, 6};
        int[] expected = new int[] {6, 5, 4, 3, 2, 1};
        assertThat(arrayTurner.back(arrayToTurn), is(expected));
    }

}
