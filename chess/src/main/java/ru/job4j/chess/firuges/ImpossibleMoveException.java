package ru.job4j.chess.firuges;

/**
 * Created by a.mogilevtsev on 1/17/2019.
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
