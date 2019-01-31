package ru.job4j.chess.firuges.general;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

/**
 * Created by a.mogilevtsev on 1/22/2019.
 */
public abstract class Bishop implements Figure {
    public final Cell position;

    public  Bishop(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.getX() - source.getX();
        int deltaY = dest.getY() - source.getY();
        int stepX, stepY;
        Cell[] result = new Cell[Math.abs(deltaX)];
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("You can't go like that");
        } else {
            stepX = Math.abs(deltaX) / deltaX;
            stepY = Math.abs(deltaY) / deltaY;
        }
        for (int index = 1; index <= Math.abs(deltaX); index++) {
            result[index - 1] = Cell.values()[(source.getX() + stepX * index) * 8 + (source.getY() + stepY * index)];
        }
        return result;
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


}
