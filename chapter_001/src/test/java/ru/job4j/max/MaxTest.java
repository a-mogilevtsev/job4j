package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int result = maximum.max(4, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenFirstMoreSecond() {
        Max maximum = new Max();
        int result = maximum.max(8, 5);
        assertThat(result, is(8));
    }

    @Test
    public void whenFirstMoreSecondAndLessThird() {
        Max maximum = new Max();
        int result = maximum.max(6, 2, 9);
        int expected = 9;
        assertThat(result, is(expected));
    }

}


