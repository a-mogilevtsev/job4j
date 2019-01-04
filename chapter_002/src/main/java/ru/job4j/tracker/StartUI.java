package ru.job4j.tracker;

/**
 * Created by Lenovo on 1/2/2019.
 */

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для просмотра всех заявок.
     */
    private static final String SHOW_ALL = "1";
    /**
     * Константа меню для редактирования.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по ключу.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска по имени.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
            } else  if (EDIT.equals(answer)) {
                this.editItem();
            } else  if (DELETE.equals(answer)) {
                this.deleteItem();
            } else  if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else  if (FIND_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showAllItems() {
        System.out.println("------------ Все существующие заявки --------------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item.getName() + " " + item.getDesc());
        }

    }

    private void editItem() {
        String id = input.ask("Введите ключ заявки для редактирования.");
        Item item = tracker.findById(id);
        if (item != null) {
            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            Item edited = new Item(name, desc);
            tracker.replace(id, edited);
        } else {
            System.out.println("Заявки с ID: " + id + " не существует");
        }
    }

    private void deleteItem() {
        String id = input.ask("Введите ключ заявки для удаления.");
        if (tracker.delete(id)) {
            System.out.println("Заявка с ID: " + id + " удалена");
        } else {
            System.out.println("Заявки с ID: " + id + " не существует");
        }

    }

    private void findItemById() {
        String id = input.ask("Введите имя заявки");
        Item finded = tracker.findById(id);
        if (finded != null) {
            System.out.println("Были найдена следующая заявка");
            System.out.println(finded.getName() + " " + finded.getDesc());

        } else {
            System.out.println("Заявки с ID: " + id + " не существует");
        }
    }

    private void findItemByName() {
        String name = input.ask("Введите имя заявки");
        Item[] finded = tracker.findByName(name);
        if (finded != null) {
            System.out.println("Были найдены следующие заявки");
            for (Item item : finded) {
                System.out.println(item.getName() + " " + item.getDesc());
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не существует");
        }
    }


    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}