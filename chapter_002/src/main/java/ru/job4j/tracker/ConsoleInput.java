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

}
