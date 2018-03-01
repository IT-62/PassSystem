package edu.Cards;

import edu.options.OwnerType;

import java.util.UUID;

public abstract class Card {
    private UUID id;
    private OwnerType ownerType;
    public UUID getID(){
        return id;
    }

    public abstract boolean verify();

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", ownerType=" + ownerType +
                '}';
    }
}
