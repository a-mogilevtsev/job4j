package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;


public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicateRemover = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expected = {"Привет", "Мир", "Супер"};
        String[] result = duplicateRemover.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expected));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutOneElement() {
        ArrayDuplicate duplicateRemover = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Супер", "Дубликат", "Дубликат"};
        String[] expected = {"Привет", "Мир", "Супер", "Дубликат"};
        String[] result = duplicateRemover.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expected));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithTwoElements() {
        ArrayDuplicate duplicateRemover = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Мир", "Мир", "Мир"};
        String[] expected = {"Привет", "Мир"};
        String[] result = duplicateRemover.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expected));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithAnotherOrder() {
        ArrayDuplicate duplicateRemover = new ArrayDuplicate();
        String[] input = {"Привет", "Привет", "Мир", "Мир", "Супер", "Супер"};
        String[] expected = {"Привет", "Мир", "Супер"};
        String[] result = duplicateRemover.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expected));
    }


}