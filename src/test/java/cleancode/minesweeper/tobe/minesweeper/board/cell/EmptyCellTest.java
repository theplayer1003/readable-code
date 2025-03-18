package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyCellTest {

    private Cell emptyCell;

    @BeforeEach
    void setup() {
        emptyCell = new EmptyCell();
    }

    @AfterEach
    void reset() {
        emptyCell = new EmptyCell();
    }

    @DisplayName("EmptyCell은 지뢰셀이 아니다")
    @Test
    void emptyCellIsNotLandMineCell() {
        assertFalse(emptyCell.isLandMine());
    }

    @DisplayName("EmptyCell은 숫자카운트를 가지지 않는다")
    @Test
    void emptyCellHasNotLandMineCount() {
        assertFalse(emptyCell.hasLandMineCount());
    }

    @DisplayName("EmptyCell은 CellState에 따라 CellSnapshot을 반환할 수 있다")
    @Test
    void emptyCell() {
        CellSnapshot emptyCellDefaultState = emptyCell.getSnapshot();
        assertTrue(emptyCellDefaultState.isSameStatus(CellSnapshotStatus.UNCHECKED));

        emptyCell.flag();
        CellSnapshot emptyCellChangedFlagState = emptyCell.getSnapshot();
        assertTrue(emptyCellChangedFlagState.isSameStatus(CellSnapshotStatus.FLAG));

        emptyCell.open();
        CellSnapshot emptyCellChangedOpenState = emptyCell.getSnapshot();
        assertTrue(emptyCellChangedOpenState.isSameStatus(CellSnapshotStatus.EMPTY));
    }
}
