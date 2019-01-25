package ru.job4j.chess.firuges;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.black.BishopBlack;

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
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = dest.getX() - source.getX();
        int deltaY = dest.getY() - source.getY();
        int stepX = Math.abs(deltaX) / deltaX;
        int stepY = Math.abs(deltaY) / deltaY;
        Cell[] result = new Cell[Math.abs(deltaX)];
        if (isDiagonal(source, dest)) {
            for (int index = 1; index <= Math.abs(deltaX); index++) {
                result[index - 1] = Cell.A1.findBy(source.getX() + stepX * index, source.getY() + stepY * index);
            }
        } else {
            throw new ImpossibleMoveException("You can't go like that");
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
