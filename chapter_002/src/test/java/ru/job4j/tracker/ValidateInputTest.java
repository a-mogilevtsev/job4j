package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Created by a.mogilevtsev on 1/12/2019.
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, enter number.%n")
                )
        );
    }
    @Test
    public void whenOutOfRangeInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"8", "6", "y"})
        );
        input.ask("Enter", new int[] {6});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter valid data%n")
                )
        );
    }
}