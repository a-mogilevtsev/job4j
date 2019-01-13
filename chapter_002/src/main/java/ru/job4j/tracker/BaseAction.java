package ru.job4j.tracker;

/**
 * Created by a.mogilevtsev on 1/13/2019.
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;


    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
    @Override
    public int key() {
        return 0;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "add new item.");
    }
}
