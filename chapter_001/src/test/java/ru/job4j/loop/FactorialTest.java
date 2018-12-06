package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class FactorialTest {
    @Test
    public void whenNumberIsFiveThenFactorialIs120() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenNumberIsSixThenFactorialIs720() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(6);
        assertThat(result, is(720));
    }

}
