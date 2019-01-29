package ru.job4j.chess.exceptions;

/**
 * Created by a.mogilevtsev on 1/17/2019.
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String message) {
        super(message);
    }
}
