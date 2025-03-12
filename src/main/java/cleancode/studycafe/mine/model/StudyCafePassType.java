package cleancode.studycafe.mine.model;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권"),
    WEEKLY("주 단위 이용권"),
    FIXED("1인 고정석");

    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getDurationDescription(int duration) {
        switch (this) {
            case HOURLY:
                return duration + "시간";
            case WEEKLY:
                return duration + "주";
            case FIXED:
                return "고정석";
            default:
                return "";
        }
    }

}
