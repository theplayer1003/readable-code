package cleancode.studycafe.mine.io;

import cleancode.studycafe.mine.model.StudyCafeLockerPass;
import cleancode.studycafe.mine.model.StudyCafePassType;
import cleancode.studycafe.mine.model.StudyCafePass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StudyCafeFileHandler implements FileHandler{

    public static final String STUDYCAFE_PASS_LIST_CSV = "src/main/resources/cleancode/studycafe/pass-list.csv";
    public static final String STUDYCAFE_LOCKER_CSV = "src/main/resources/cleancode/studycafe/locker.csv";

    @Override
    public List<StudyCafePass> readStudyCafePassesFromCSV() {
        return readFile(STUDYCAFE_PASS_LIST_CSV, this::parseStudyCafePass);
    }

    @Override
    public List<StudyCafeLockerPass> readLockerPassesFromCSV() {
        return readFile(STUDYCAFE_LOCKER_CSV, this::parseStudyCafeLockerPass);
    }

    private <T> List<T> readFile(String filepath, Function<String, T> parser) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filepath));
            List<T> passes = new ArrayList<>();
            for (String line : lines) {
                passes.add(parser.apply(line));
            }
            return passes;
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    private StudyCafePass parseStudyCafePass(String line) {
        String[] values = line.split(",");
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);
        double discountRate = Double.parseDouble(values[3]);

        return StudyCafePass.of(studyCafePassType, duration, price, discountRate);
    }

    private StudyCafeLockerPass parseStudyCafeLockerPass(String line) {
        String[] values = line.split(",");
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);

        return StudyCafeLockerPass.of(studyCafePassType, duration, price);
    }

}
