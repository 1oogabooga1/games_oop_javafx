package ru.job4j.chess;

import org.junit.jupiter.api.Test;

import ru.job4j.chess.firuges.Cell;

import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import ru.job4j.chess.firuges.black.KingBlack;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    void whenNotFree() {
        Logic log = new Logic();
        log.add(new BishopBlack(Cell.C1));
        log.add(new KingBlack(Cell.D2));
        Cell[] steps = new Cell[] {Cell.A1, Cell.D2};
        Assert.assertThrows(OccupiedCellException.class, () -> log.move(Cell.C1, Cell.D2));
    }

    @Test
    void whenImpossibleMove() {
        Logic log = new Logic();
        log.add(new BishopBlack(Cell.C1));
        Assert.assertThrows(ImpossibleMoveException.class, () -> log.move(Cell.C1, Cell.C3));
    }

    @Test
    void whenFigureNotFound() {
        Logic log = new Logic();
        log.add(new BishopBlack(Cell.C1));
        Assert.assertThrows(FigureNotFoundException.class, () -> log.move(Cell.C2, Cell.D3));
    }
}