package edu.options;

public enum DurationType {
    TEN_DAYS(10),
    MONTH(30),
    NULL(0);
    private int daysLeft;

    DurationType(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft() {
        return daysLeft;
    }
}
