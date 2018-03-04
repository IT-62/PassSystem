package edu.Cards;

import edu.options.OwnerType;

import java.util.UUID;

public abstract class Card {
    private UUID id;
    private OwnerType ownerType;
    public Card(UUID id, OwnerType ownerType) {
        this.id = id;
        this.ownerType = ownerType;
    }

    public UUID getID(){
        return id;
    }
    public OwnerType getOwnerType() {
        return ownerType;
    }

    public abstract boolean verify();

    public abstract String toString();

}
