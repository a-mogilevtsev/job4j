package ru.job4j.chess.firuges.general;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Created by a.mogilevtsev on 1/26/2019.
 */
public abstract class Pawn implements Figure {
    public final Cell position;

    public Pawn(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int deltaY = dest.getY() - source.getY();
        if (dest.y == source.y + deltaY && source.x == dest.x && Math.abs(deltaY) == 1) {
            steps = new Cell[] {dest};
        }
        return steps;
    }
}
