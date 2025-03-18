package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CellsTest {

    private Cell landMineCell;
    private Cell numberCell;
    private Cell emptyCell;

    @BeforeEach
    void setUp() {
        landMineCell = new LandMineCell();
        numberCell = new NumberCell(2);
        emptyCell = new EmptyCell();
    }

    @DisplayName("체크되지 않은 셀이 있으면 false를 반환한다")
    @Test
    void test() {
        landMineCell.flag();
        numberCell.open();

        Cells cells = Cells.of(List.of(landMineCell, numberCell, emptyCell));

        assertFalse(cells.isAllChecked());
    }
}
