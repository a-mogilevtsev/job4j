package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author A.Mogilevtsev (a.mogilevtsev@gmail.com)
* @version 1
* @since 03.12.2018
*/
public class CalculateTest {
/**
* Test echo.
*/
@Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Andrey Mogilevtsev";
    String expect = "Echo, echo, echo : Andrey Mogilevtsev"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}