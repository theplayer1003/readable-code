package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.game.GameRunnable;

public class AnotherGame /*implements Game*/ implements GameRunnable {

//    @Override
//    public void initialize() {
//        // 만약 이 게임이 이니셜라이즈를 안 쓰는 게임이라면.
//        // 필요 없는 기능인데 들고 있으면 나중에 이니셜라이즈 변경 시 영향 받음.
//    }

    @Override
    public void run() {
        // 게임만 진행하면 되는 구현체.
    }
}
