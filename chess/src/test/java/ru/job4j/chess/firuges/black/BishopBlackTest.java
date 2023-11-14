package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;

import ru.job4j.chess.ImpossibleMoveException;

import ru.job4j.chess.firuges.Cell;

import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
    @Test
    void whenPosition() {
        BishopBlack pos = new BishopBlack(Cell.C2);
        pos.position();
        assertThat(pos.position()).isEqualTo(Cell.C2);
    }

    @Test
    void whenCopy() {
        BishopBlack cop = new BishopBlack(Cell.A4);
        Figure co = cop.copy(Cell.A5);
        Cell exp = Cell.A5;
        Cell rsl = co.position();
        assertThat(rsl).isEqualTo(exp);
    }

    @Test
    void whenWay() {
        BishopBlack wa = new BishopBlack(Cell.C1);
        Cell[] exp = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(wa.way(Cell.G5)).isEqualTo(exp);
    }

    @Test
    void whenDiagonal() {
        BishopBlack diag = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> {
                    diag.way(Cell.C2);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to C2");
    }

}