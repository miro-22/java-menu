package menu.domain;

public enum Weekday {
    MON("월요일", 1),
    TUE("화요일", 2),
    WED("수요일", 3),
    THU("목요일", 4),
    FRI("금요일", 5);

    private final String title;
    private final int index;

    Weekday(String title, int index) {
        this.title = title;
        this.index = index;
    }

    public String getTitle() {
        return this.title;
    }

    public int getIndex() {
        return this.index;
    }
}
