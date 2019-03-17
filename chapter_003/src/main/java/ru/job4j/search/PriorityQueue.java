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
        int addPosition = tasks.size();
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                addPosition = i;
                break;
            }
        }
        tasks.add(addPosition, task );
    }

    public Task take() {
        return this.tasks.poll();
    }
}

