package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {
        @Test
        public void whenAddItemAndFindAllThenReturnArrayContainsIt() {
                Tracker tracker = new Tracker();
                Item first = new Item("test1", "testDescription", 123L);
                tracker.add(first);
                Item second = new Item("test2", "testDescription2", 23446L);
                tracker.add(second);
                Item third = new Item("test1", "testDescription3", 34512L);
                tracker.add(third);
                Item[] finded = tracker.findAll();
                Assert.assertThat(finded.length, is(3));
        }

        @Test
        public void whenReplaceNameThenReturnNewName() {
                Tracker tracker = new Tracker();
                Item previous = new Item("test1", "testDescription", 123L);
                tracker.add(previous);
                Item next = new Item("test2", "testDescription2", 1234L);
                next.setId(previous.getId());
                tracker.replace(previous.getId(), next);
                assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        }

        @Test
        public void whenFindByNameThenReturnArrayWith() {
                Tracker tracker = new Tracker();
                Item first = new Item("test1", "testDescription", 123L);
                tracker.add(first);
                Item second = new Item("test2", "testDescription2", 23446L);
                tracker.add(second);
                Item third = new Item("test1", "testDescription3", 34512L);
                tracker.add(third);
                Item[] finded = tracker.findByName("test1");
                int count = 2;
                Assert.assertThat(finded.length, is(count));
                for (Item item : finded) {
                        Assert.assertThat(item.getName(), is("test1"));
                }
        }

        @Test
        public void whenRemoveItemThenReturnArrayWithout() {
                Tracker tracker = new Tracker();
                Item first = new Item("test1", "testDescription", 123L);
                tracker.add(first);
                Item second = new Item("test2", "testDescription2", 1234L);
                tracker.add(second);
                Item third = new Item("test1", "testDescription3", 34512L);
                tracker.add(third);
                Item[] finded = tracker.findByName("test1");
                for (Item item : finded) {
                        if (item == null) {
                                break;
                        }
                        tracker.delete(item.getId());
                }
                Assert.assertThat(tracker.findByName("test1").length, is(0));
        }

        @Test
        public void whenFindAllThenReturnArrayWithAll() {
                Tracker tracker = new Tracker();
                Item[] expected = new Item[2];
                Item first = new Item("test1", "testDescription", 123L);
                expected[0] = tracker.add(first);
                Item second = new Item("test2", "testDescription2", 1234L);
                expected[1] = tracker.add(second);
                Item[] finded = tracker.findAll();
                Assert.assertArrayEquals(expected, finded);
        }
}