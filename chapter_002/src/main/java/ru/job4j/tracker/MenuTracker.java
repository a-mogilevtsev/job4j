package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());

            }
        }
    }

    public class AddItem extends BaseAction {

        public AddItem(int key, String message) {
            super(key, message);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println(String.format("------------ New Item with Id : %s", item.getId()));
            System.out.println(String.format("------------ New Item with Name : %s", item.getName()));
            System.out.println(String.format("------------ New Item with Description : %s", item.getDesc()));
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String message) {
            super(key, message);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ключ заявки для удаления.");
            if (tracker.delete(id)) {
                System.out.println(String.format("Заявка с ID: %s удалена", id));
            } else {
                System.out.println(String.format("Заявки с ID: %s не существует", id));
            }
        }
    }

    public class FindItemById extends BaseAction {

        public FindItemById(int key, String message) {
            super(key, message);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите имя заявки");
            Item finded = tracker.findById(id);
            if (finded != null) {
                System.out.println("Были найдены следующие заявки");
                System.out.println(finded.getName() + " " + finded.getDesc());

            } else {
                System.out.println(String.format("Заявки с ID: %s не существует", id));
            }
        }
    }

    public class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String message) {
            super(key, message);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки");
            Item[] finded = tracker.findByName(name);
            if (finded != null) {
                System.out.println("Были найдены следующие заявки");
                for (Item item : finded) {
                    System.out.println(item.getName() + " " + item.getDesc());
                }
            } else {
                System.out.println(String.format("Заявки с именем: %s не существует", name));
            }
        }

    }

    public class ShowItems extends BaseAction {

        public ShowItems(int key, String message) {
            super(key, message);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все существующие заявки --------------");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println(item.getName() + " " + item.getDesc());
            }
        }
    }

    public class UpdateItem extends BaseAction {

        public UpdateItem(int key, String message) {
            super(key, message);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ключ заявки для редактирования.");
            Item item = tracker.findById(id);
            if (item != null) {
                String name = input.ask("Введите имя заявки :");
                String desc = input.ask("Введите описание заявки :");
                Item edited = new Item(name, desc);
                tracker.replace(id, edited);
            } else {
                System.out.println(String.format("Заявки с ID: %s не существует", id));
            }
        }

    }

    public class ExitProgram extends BaseAction {

        public ExitProgram(int key, String message) {
            super(key, message);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            input.ask("Exit?(y): ");
        }
    }
}
