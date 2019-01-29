package ru.job4j;

import org.junit.*;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.firuges.black.KnightBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.*;

import static org.hamcrest.core.Is.is;

/**
 * Created by a.mogilevtsev on 1/19/2019.
 */
public class FigureMoveTest {
    public static Logic logic;

    @Before
    public void prepareForTests() {
        logic = new Logic();
    }

    @After
    public void finish() {
        logic.clean();
    }

    @Test
    public void figureNotFoundTry() {
        try {
            logic.move(Cell.A1, Cell.A5);
        } catch (FigureNotFoundException fnfe) {
            Assert.assertThat(fnfe.getMessage(), is("There is no figure"));
        }
    }

    @Test
    public void bishopRightMove() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        logic.add(bishopBlack);
        logic.move(Cell.A1, Cell.D5);
        Assert.assertThat(logic.move(Cell.A1, Cell.E5), is(true));
    }

    @Test
    public void bishopWrongMove() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        logic.add(bishopBlack);
        try {
            logic.move(Cell.A1, Cell.D5);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("You can't go like that"));
        }
    }

    @Test
    public void bishopWrongMoveOccupiedCell() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Figure bishopWhite = new BishopWhite(Cell.B2);
        logic.add(bishopBlack);
        logic.add(bishopWhite);
        try {
            logic.move(Cell.A1, Cell.E5);
        } catch (OccupiedWayException owe) {
            Assert.assertThat(owe.getMessage(), is("Something on the way"));
        }
    }

    @Test
    public void kingRightMove() {
        Figure kingWhite = new KingWhite(Cell.E1);
        logic.add(kingWhite);
        Assert.assertThat(logic.move(Cell.E1, Cell.E2), is(true));
    }

    @Test
    public void kingWrongMove() {
        Figure kingWhite = new KingWhite(Cell.E1);
        logic.add(kingWhite);
        try {
            logic.move(Cell.E1, Cell.E4);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("You can't go like that"));
        }
    }

    @Test
    public void kingWrongMoveOccupiedCell() {
        Figure kingWhite = new KingWhite(Cell.E1);
        Figure bishopWhite = new BishopWhite(Cell.F1);
        logic.add(kingWhite);
        logic.add(bishopWhite);
        try {
            logic.move(Cell.E1, Cell.F1);
        } catch (OccupiedWayException owe) {
            Assert.assertThat(owe.getMessage(), is("Something on the way"));
        }
    }

    @Test
    public void rookRightMove() {
        Figure rookWhite = new RookWhite(Cell.A1);
        logic.add(rookWhite);
        Assert.assertThat(logic.move(Cell.A1, Cell.A5), is(true));
        Assert.assertThat(logic.move(Cell.A5, Cell.E5), is(true));
    }

    @Test
    public void rookWrongMove() {
        Figure rookWhite = new RookWhite(Cell.A1);
        logic.add(rookWhite);
        try {
            logic.move(Cell.A1, Cell.C2);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("You can't go like that"));
        }
    }

    @Test
    public void pawnRightMove() {
        Figure pawnBlack = new PawnBlack(Cell.A7);
        logic.add(pawnBlack);
        Assert.assertThat(logic.move(Cell.A7, Cell.A6), is(true));
    }

    @Test
    public void pawnWrongMove() {
        Figure pawnBlack = new PawnBlack(Cell.A7);
        logic.add(pawnBlack);
        try {
            logic.move(Cell.A7, Cell.A6);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("You can't go like that"));
        }
    }

    @Test
    public void queenRightMove() {
        Figure queen = new QeenWhite(Cell.D8);
        logic.add(queen);
        Assert.assertThat(logic.move(Cell.D8, Cell.H4), is(true));
        Assert.assertThat(logic.move(Cell.H4, Cell.A4), is(true));
    }

    @Test
    public void queenWrongMove() {
        Figure queen = new QeenWhite(Cell.D8);
        logic.add(queen);
        try {
            logic.move(Cell.D8, Cell.A6);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("You can't go like that"));
        }
    }

    @Test
    public void knightRightMove() {
        Figure knight = new KnightBlack(Cell.G8);
        logic.add(knight);
        Assert.assertThat(logic.move(Cell.G8, Cell.H6), is(true));
    }

    @Test
    public void knightWrongMove() {
        Figure knight = new KnightBlack(Cell.G8);
        logic.add(knight);
        try {
            logic.move(Cell.G8, Cell.A6);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("You can't go like that"));
        }
    }

}
