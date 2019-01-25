package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Chess;
import ru.job4j.chess.firuges.Bishop;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Bishop {

    public BishopBlack(Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
