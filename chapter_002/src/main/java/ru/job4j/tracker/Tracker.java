package ru.job4j.tracker;

import java.util.Random;

/**
 * Created by Lenovo on 12/31/2018.
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private static final Random RN = new Random();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализующий замену одной заявки другой
     * @param id
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && id.equals(items[index].getId())) {
                items[index] = item;
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод реализующий удаление элемента массива
     * @par1am id
     * @return
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && id.equals(items[index].getId())) {
                System.arraycopy(items, index + 1, items, index, items.length - 1 - index);
                result = true;
                position--;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращающий массив со всеми заявками
     * @return
     */
    public Item[] findAll() {
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                count++;
            }
        }
        Item[] allItems = new Item[count];
        System.arraycopy(items, 0, allItems, 0, count);
        return allItems;
    }

    /**
     * Метод возвращающий заявку с заданным именем
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[items.length];
        int count = 0;
        for (Item item : items) {
            if (item == null) {
                break;
            }
            if (key.equals(item.getName())) {
                temp[count] = item;
                count++;
            }

        }
        Item[] result = new Item[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }

    /**
     * Метод возвращаюший заявку с заданным id
     * @param id
     * @return
     */
    public Item findById(String id) {
       Item result = null;
        for (Item item : items) {
            if (item != null && id.equals(item.getId())) {
                result = item;
            }
        }
        return result;
    }


    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}

