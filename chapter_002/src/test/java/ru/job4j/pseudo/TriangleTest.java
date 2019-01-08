package ru.job4j.pseudo;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;


/**
 * Created by a.mogilevtsev on 1/8/2019.
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle tr = new Triangle();
        Assert.assertThat(tr.draw(), is(new StringBuilder()
                        .append("  +  ")
                        .append(" + + ")
                        .append("+   +")
                        .append("+++++").toString()));
    }
}
