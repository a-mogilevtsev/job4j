package ru.job4j.chess.firuges;

/**
 * Created by a.mogilevtsev on 1/17/2019.
 */
public class OccupiedWayException extends Exception {
    public OccupiedWayException() {
    }

    public OccupiedWayException(String message) {
        super(message);
    }
}
