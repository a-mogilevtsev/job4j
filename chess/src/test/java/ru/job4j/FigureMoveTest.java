package ru.job4j;

import org.junit.*;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.BishopWhite;
import ru.job4j.chess.firuges.white.KingWhite;

import static org.hamcrest.core.Is.is;

/**
 * Created by a.mogilevtsev on 1/19/2019.
 */
public class FigureMoveTest {
    public static Logic logic;
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

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
        expectedEx.expect(FigureNotFoundException.class);
        expectedEx.expectMessage("There is no figure");
        logic.move(Cell.A1, Cell.A5);
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
        expectedEx.expect(ImpossibleMoveException.class);
        expectedEx.expectMessage("You can't go like that");
        logic.add(bishopBlack);
        logic.move(Cell.A1, Cell.D5);
    }

    @Test
    public void bishopWrongMoveOccupiedCell() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Figure bishopWhite = new BishopWhite(Cell.B2);
        expectedEx.expect(OccupiedWayException.class);
        expectedEx.expectMessage("Something on the way");
        logic.add(bishopBlack);
        logic.add(bishopWhite);
        logic.move(Cell.A1, Cell.E5);
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
        expectedEx.expect(ImpossibleMoveException.class);
        expectedEx.expectMessage("You can't go like that");
        logic.move(Cell.E1, Cell.E4);
    }

    @Test
    public void kingWrongMoveOccupiedCell() {
        Figure kingWhite = new KingWhite(Cell.E1);
        Figure bishopWhite = new BishopWhite(Cell.F1);
        logic.add(kingWhite);
        logic.add(bishopWhite);
        expectedEx.expect(OccupiedWayException.class);
        expectedEx.expectMessage("Something on the way");
        logic.move(Cell.E1, Cell.F1);


    }

}
