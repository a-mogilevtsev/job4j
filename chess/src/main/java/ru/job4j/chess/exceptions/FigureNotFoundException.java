package ru.job4j.chess.exceptions;

/**
 * Created by a.mogilevtsev on 1/17/2019.
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String message) {
        super(message);
    }
}
