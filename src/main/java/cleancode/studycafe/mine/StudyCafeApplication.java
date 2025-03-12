package cleancode.studycafe.mine;

import cleancode.studycafe.mine.config.StudyCafeConfig;
import cleancode.studycafe.mine.io.ConsoleInputHandler;
import cleancode.studycafe.mine.io.ConsoleOutputHandler;
import cleancode.studycafe.mine.io.StudyCafeFileHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeConfig studyCafeConfig = new StudyCafeConfig(
            new StudyCafeFileHandler(),
            new ConsoleInputHandler(),
            new ConsoleOutputHandler()
        );

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeConfig);
        studyCafePassMachine.run();
    }

}
