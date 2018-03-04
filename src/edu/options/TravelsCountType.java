package edu.options;

public enum  TravelsCountType {
    FIVE(5),
    TEN(10),
    NULL(0);
    private int travelsLeft;

    TravelsCountType(int passesLeft) {
        this.travelsLeft = passesLeft;
    }

    public int getTravelsLeft() {
        return travelsLeft;
    }
}
