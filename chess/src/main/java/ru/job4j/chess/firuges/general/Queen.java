package ru.job4j.chess.firuges.general;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Created by a.mogilevtsev on 1/27/2019.
 */
public abstract class Queen implements Figure {
    public final Cell position;

    public Queen(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaY = dest.getY() - source.getY();
        int deltaX = dest.getX() - source.getX();
        int stepX, stepY;
        int size = Math.abs(deltaX) >= Math.abs(deltaY) ? Math.abs(deltaX) : Math.abs(deltaY);
        Cell[] steps = new Cell[size];
        if (!(isDiagonal(source, dest) || isStraight(source, dest))) {
            throw new ImpossibleMoveException("You can't go like that");
        }
        if (deltaX == 0) {
            stepX = 0;
        } else {
            stepX = deltaX > 0 ? 1 : -1;
        }

        if (deltaY == 0) {
            stepY = 0;
        } else {
            stepY = deltaY > 0 ? 1 : -1;
        }
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = Cell.A1.findBy(source.getX() + stepX * i, source.getY() + stepY * i);
        }

        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = dest.getX() - source.getX();
        int deltaY = dest.getY() - source.getY();
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            result = true;
        }
        return result;
    }

    public boolean isStraight(Cell source, Cell dest) {
        int deltaX = dest.getX() - source.getX();
        int deltaY = dest.getY() - source.getY();
        boolean result = false;
        if ((source.y == dest.y && Math.abs(deltaX) > 0) || (source.x == dest.x && Math.abs(deltaY) > 0)) {
            result = true;
        }
        return result;
    }
}
