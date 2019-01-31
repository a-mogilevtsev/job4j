package ru.job4j.chess.firuges.general;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Created by a.mogilevtsev on 1/26/2019.
 */
public abstract class Rook implements Figure {
    public final Cell position;

    public Rook(Cell position) {
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
        Cell[] steps;
        if (!((source.y == dest.y && Math.abs(deltaX) > 0) || (source.x == dest.x && Math.abs(deltaY) > 0))) {
            throw new ImpossibleMoveException("You can't go like that");
        }

        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            steps = new Cell[Math.abs(deltaX)];
            stepX = Math.abs(deltaX) / deltaX;
            stepY = 0;
        } else {
            steps = new Cell[Math.abs(deltaY)];
            stepX = 0;
            stepY = Math.abs(deltaY) / deltaY;
        }

        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = Cell.A1.values()[(source.getX() + stepX * i) * 8 + source.getY() + stepY * i];
        }
        return steps;
    }
}
