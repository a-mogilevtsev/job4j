package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by a.mogilevtsev on 1/7/2019.
 */
public class StartUITest {
    @Test
    public void whenAddItemThenItIsAdded() {
        String[] commands = {"0", "firstName", "firstDescription", "0", "secondName", "secondDescription", "6"};
        Input input = new StubInput(commands);
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        Item[] finded = tracker.findAll();
        Assert.assertThat(finded.length, is(2));
        Assert.assertThat(finded[0].getName(), is("firstName"));
        Assert.assertThat(finded[1].getName(), is("secondName"));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        String[] commands = {"0", "firstName", "firstDescription", "0", "secondName", "secondDescription", "6"};
        Input input = new StubInput(commands);
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        String id = tracker.findByName("firstName")[0].getId();
        tracker.replace(id, new Item("ReplacedName", "replacedDesripion"));
        Assert.assertThat(tracker.findByName("ReplacedName").length, is(1));
        Assert.assertThat(tracker.findByName("firstName").length, is(0));
    }
    @Test
    public void whenFindByNameThenReturnArrayWith() {
        String[] commands = {"0", "firstName", "firstDescription", "0", "secondName", "secondDescription",
                            "0", "firstName", "AnotherDescription", "6"};
        Input input = new StubInput(commands);
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findByName("secondName").length, is(1));
        Assert.assertThat(tracker.findByName("firstName").length, is(2));
    }
    @Test
    public void whenRemoveItemThenReturnArrayWithout() {
        String[] commands = {"0", "firstName", "firstDescription", "0", "secondName", "secondDescription", "6"};
        Input input = new StubInput(commands);
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        String id = tracker.findByName("firstName")[0].getId();
        tracker.delete(id);
        Assert.assertThat(tracker.findByName("firstName").length, is(0));
    }
    @Test
    public void whenFindAllThenReturnArrayWithAll() {
        String[] commands = {"0", "test1", "testDescription", "0", "test2", "testDescription2", "6"};
        Input input = new StubInput(commands);
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        Assert.assertThat(tracker.findAll()[0].getName(), is("test1"));
        Assert.assertThat(tracker.findAll()[1].getName(), is("test2"));
        Assert.assertThat(tracker.findAll().length, is(2));
    }
}
