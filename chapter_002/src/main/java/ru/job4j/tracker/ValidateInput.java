package ru.job4j.tracker;

/**
 * Created by a.mogilevtsev on 1/12/2019.
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter number.");
            } catch (MenuOutException nfe) {
                System.out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
}
