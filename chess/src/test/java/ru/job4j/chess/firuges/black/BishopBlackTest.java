package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.chess.firuges.Cell.*;
import static ru.job4j.chess.firuges.Cell.G5;

class BishopBlackTest {
    @Test
    public void whenPosition() {
        BishopBlack bishop  = new BishopBlack(C8);
        Cell rsl = bishop.position();
        Cell expected = C8;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenCopy() {
        BishopBlack bishop  = new BishopBlack(C8);
        Cell rsl = bishop.copy(A6).position();
        Cell expected = A6;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenWay() {
        BishopBlack bishop  = new BishopBlack(C1);
        Cell[] rsl = bishop.way(G5);
        Cell[] expected = {D2, E3, F4, G5};
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenWayThenException() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    new BishopBlack(C1).way(G4);
                });
        assertThat(exception.getMessage()).isEqualTo(
                String.format("Could not move by diagonal from %s to %s.", Cell.C1, Cell.G4)
        );
    }
}