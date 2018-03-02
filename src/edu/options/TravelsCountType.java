package edu.options;

public enum  TravelsCountType {
    FIVE(5),
    TEN(10);

    private int passesLeft;

    TravelsCountType(int passesLeft) {
        this.passesLeft = passesLeft;
    }

    public int getPassesLeft() {
        return passesLeft;
    }
}
