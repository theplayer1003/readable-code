package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;

public interface CellSignProvidable {
    // 셀스냅샷을 넘겨줬을때 그에 맞는 사인을 찾아주는 역할
    String provide(CellSnapshot cellSnapshot);

    boolean supports(CellSnapshot cellSnapshot);

}
