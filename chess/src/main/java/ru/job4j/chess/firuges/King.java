package ru.job4j.chess.firuges;

import ru.job4j.chess.firuges.white.KingWhite;

import java.util.Map;

/**
 * Created by a.mogilevtsev on 1/25/2019.
 */
public abstract class King implements Figure {
    public final Cell position;

    public King(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = dest.getX() - dest.getX();
        int deltaY = dest.getY() - source.getY();
        if (Math.abs(deltaX) > 1 || Math.abs(deltaY) > 1 || Math.abs(deltaX) + Math.abs(deltaY) > 2) {
            throw new ImpossibleMoveException("You can't go like that");
        }
        return new Cell[] {dest};
    }



}
