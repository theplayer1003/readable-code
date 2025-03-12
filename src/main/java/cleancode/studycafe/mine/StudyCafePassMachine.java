package cleancode.studycafe.mine;

import cleancode.studycafe.mine.config.StudyCafeConfig;
import cleancode.studycafe.mine.exception.AppException;
import cleancode.studycafe.mine.io.*;
import cleancode.studycafe.mine.model.StudyCafeLockerPass;
import cleancode.studycafe.mine.model.StudyCafePassType;
import cleancode.studycafe.mine.model.StudyCafePass;

import java.util.List;

public class StudyCafePassMachine {

    private final FileHandler fileHandler;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public StudyCafePassMachine(StudyCafeConfig studyCafeConfig) {
        this.fileHandler = studyCafeConfig.getFileHandler();
        this.inputHandler = studyCafeConfig.getInputHandler();
        this.outputHandler = studyCafeConfig.getOutputHandler();
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            List<StudyCafePass> studyCafePasses = fileHandler.readStudyCafePassesFromCSV();
            List<StudyCafePass> selectedPasses = filterPassesByType(studyCafePasses, studyCafePassType);
            outputHandler.showPassListForSelection(selectedPasses);

            StudyCafePass selectedPass = inputHandler.getSelectPass(selectedPasses);
            outputHandler.showPassOrderSummary(selectedPass, null);

            if (studyCafePassType == StudyCafePassType.FIXED) {
                handleLockerPass(selectedPass);
            }

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private List<StudyCafePass> filterPassesByType(List<StudyCafePass> studyCafePasses, StudyCafePassType passType) {
        return studyCafePasses.stream()
            .filter(pass -> pass.getPassType() == passType)
            .toList();
    }

    private void handleLockerPass(StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> lockerPasses = fileHandler.readLockerPassesFromCSV();
        StudyCafeLockerPass lockerPass = findMatchingLockerPass(lockerPasses, selectedPass);

        if (lockerPass != null) {
            outputHandler.askLockerPass(lockerPass);
            boolean lockerSelection = inputHandler.getLockerSelection();
            outputHandler.showPassOrderSummary(selectedPass, lockerSelection ? lockerPass : null);
        }
    }

    private StudyCafeLockerPass findMatchingLockerPass(List<StudyCafeLockerPass> lockerPasses, StudyCafePass selectedPass) {
        return lockerPasses.stream()
            .filter(locker -> locker.getPassType() == selectedPass.getPassType() && locker.getDuration() == selectedPass.getDuration())
            .findFirst()
            .orElse(null);
    }

}
