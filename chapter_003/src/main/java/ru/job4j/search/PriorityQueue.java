package ru.job4j.search;

import java.util.LinkedList;

/**
 * Created by a.mogilevtsev on 3/6/2019.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        int arrSize = tasks.size();
        for (int i = 0; i <= arrSize; i++) {
            if (tasks.isEmpty() || i == arrSize) {
                tasks.add(task);
            } else {
                if (tasks.get(i).getPriority() > task.getPriority()) {
                    tasks.add(i, task);
                    break;
                }
            }
        }

    }

    public Task take() {
        return this.tasks.poll();
    }
}

