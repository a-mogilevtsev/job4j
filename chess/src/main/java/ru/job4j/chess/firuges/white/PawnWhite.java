package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.general.Pawn;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite extends Pawn {

    public PawnWhite(final Cell position) {
        super(position);
    }


    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
