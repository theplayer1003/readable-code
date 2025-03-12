package cleancode.studycafe.mine.config;

import cleancode.studycafe.mine.io.FileHandler;
import cleancode.studycafe.mine.io.InputHandler;
import cleancode.studycafe.mine.io.OutputHandler;

public class StudyCafeConfig {
    private final FileHandler fileHandler;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public StudyCafeConfig(FileHandler fileHandler, InputHandler inputHandler, OutputHandler outputHandler) {
        this.fileHandler = fileHandler;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }
}
