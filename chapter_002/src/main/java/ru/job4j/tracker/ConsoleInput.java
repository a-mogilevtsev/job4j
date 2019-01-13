package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Created by Lenovo on 1/3/2019.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }
    public int ask(String question, int[] range) {
        int value = -1;
        boolean exist = false;
        int inp = Integer.valueOf(scanner.next());
            for (int index = 0; index < range.length; index++){
                if (inp == range[index]) {
                    value = inp;
                    exist = true;
                    break;
                }
            }
        if(!exist) {
            throw new MenuOutException("Введите число из диапазона меню");
        }
        return value;
    }

}
