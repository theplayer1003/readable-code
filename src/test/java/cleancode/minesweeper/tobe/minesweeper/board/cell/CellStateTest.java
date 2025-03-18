package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CellStateTest {

    @DisplayName("CellState는 false로 초기화 된다")
    @Test
    void cellInitializedFalse() {
        // given
        CellState cellState = CellState.initialize();

        // when
        boolean opened = cellState.isOpened();
        boolean flagged = cellState.isFlagged();

        // then
        assertFalse(opened);
        assertFalse(flagged);
    }

    @DisplayName("CellState는 자신의 isFlagged 상태를 true로 바꿀 수 있다")
    @Test
    void changeIsFlaggedToTrue() {
        // given
        CellState cellState = CellState.initialize();

        // when
        cellState.flag();

        // then
        assertTrue(cellState.isFlagged());
    }

    @DisplayName("CellState는 자신의 isOpened 상태를 true로 바꿀 수 있다")
    @Test
    void changeIsOpendToTrue() {
        // given
        CellState cellState = CellState.initialize();

        // when
        cellState.open();

        // then
        assertTrue(cellState.isOpened());
    }
}
