package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.general.Pawn;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack extends Pawn {

    public PawnBlack(final Cell position) {
        super(position);
    }


    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
