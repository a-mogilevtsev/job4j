package ru.job4j.tracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by a.mogilevtsev on 1/9/2019.
 */
public class StartUITestWithReplacedOut {
    private final PrintStream out = System.out;
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private final String menu = "Меню:" + System.lineSeparator()
            + "0. Add new item"
            + System.lineSeparator()
            + "1. Show all items"
            + System.lineSeparator()
            + "2. Edit item"
            + System.lineSeparator()
            + "3. Delete item"
            + System.lineSeparator()
            + "4. Find item by Id"
            + System.lineSeparator()
            + "5. Find items by name"
            + System.lineSeparator()
            + "6. Exit Program"
            + System.lineSeparator();
    private final String prefix = "------------ Все существующие заявки --------------"
            + System.lineSeparator();
    private Tracker tracker = new Tracker();

    @Before
    public void replaceOutputStream() {
        System.setOut(new PrintStream(baos));
    }

    @Before
    public void fillTracker() {
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 23446L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 34512L);
        tracker.add(third);

    }

    @After
    public void setBackStandardOutput() {
        System.setOut(out);
    }

    @Test
    public void whenUserChooseShowAll() {
        String[] commands = {"1", "6"};
        Input sti = new StubInput(commands);
        new StartUI(sti, tracker).init();
        String expectedResult = "test1 testDescription" + System.lineSeparator()
                + "test2 testDescription2" + System.lineSeparator()
                + "test3 testDescription3" + System.lineSeparator();
        Assert.assertThat(baos.toString(), is((menu + prefix + expectedResult + menu)));
    }

    @Test
    public void whenUserAddNewItem() {
        String[] commands = {"0", "newItem", "newDesc", "6" };
        Input sti = new StubInput(commands);
        new StartUI(sti, tracker).init();
        String id = tracker.findByName("newItem")[0].getId();
        String expectedResult = "------------ Добавление новой заявки --------------"
                + System.lineSeparator()
                + "------------ Новая заявка с getId : " + id + "-----------"
                + System.lineSeparator();
        Assert.assertThat(baos.toString(), is(menu + expectedResult + menu));
    }

    @Test
    public void whenUserFindItemByName(){
        String[] commands = {"5", "test2" , "6"};
        Input sti = new StubInput(commands);
        new StartUI(sti, tracker).init();
        String expected = menu + "Были найдены следующие заявки" + System.lineSeparator()
                + "test2 testDescription2" + System.lineSeparator() + menu;
        Assert.assertThat(baos.toString(), is(expected));
    }

}
