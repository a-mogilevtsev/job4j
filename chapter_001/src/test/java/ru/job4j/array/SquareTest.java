package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
public class SquareTest {

    @Test
    public void whenCountIs3thanA149() {
        Square square = new Square();
        int count = 3;
        int[] expected = new int[] {1, 4, 9};
        int[] result = square.calculate(count);
        assertThat(result, is(expected));
    }


    @Test
    public void whenCountIs4thanA14916() {
        Square square = new Square();
        int count = 4;
        int[] expected = new int[] {1, 4, 9, 16};
        int[] result = square.calculate(count);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCountIs6thanA149162536() {
        Square square = new Square();
        int count = 6;
        int[] expected = new int[] {1, 4, 9, 16, 25, 36};
        int[] result = square.calculate(count);
        assertThat(result, is(expected));
    }

}
