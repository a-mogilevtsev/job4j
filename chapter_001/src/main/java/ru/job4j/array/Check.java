package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean sample = data[0];
        for (boolean item : data) {
            if (item != sample) {
                result = false;
                break;
            }

        }
        return result;
    }
}