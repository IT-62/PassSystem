package edu.Cards;

import edu.options.OwnerType;
import edu.options.TravelsCountType;

import java.util.UUID;

public class MultiJourneyCard extends Card {
    private int travelsLeft;
    private TravelsCountType travelsCountType;
    public MultiJourneyCard(UUID id, OwnerType ownerType, TravelsCountType travelsCountType) {
        super(id, ownerType);
        this.travelsLeft = travelsCountType.getTravelsLeft();
        this.travelsCountType = travelsCountType;
    }

    public int getTravelsLeft() {
        return travelsLeft;
    }

    @Override
    public boolean verify() {
        if(travelsLeft > 0){
            travelsLeft--;
            return true;
        }
        return false;
    }
}
