package edu;

import edu.Cards.Card;
import edu.Cards.CumulativeCard;
import edu.Cards.MultiJourneyCard;
import edu.Cards.TemporaryCard;
import edu.options.DurationType;
import edu.options.OwnerType;
import edu.options.TravelsCountType;

import java.util.ArrayList;
import java.util.UUID;

public class ContolSystem {
    private  static ContolSystem instance;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Turnstile> turnstiles = new ArrayList<>();
    public int travelPrice = 4;
    public ArrayList<Pass> passes = new ArrayList<>();
  
    private ContolSystem() {
    }

    public static ContolSystem getInstance() {
        if(instance == null) {
            instance = new ContolSystem();
        }
        return instance;
    }

    public void createTurnstile(ContolSystem contolSystem, UUID id) {

    }

    public void createCard(OwnerType ownerType, int balance) {
        cards.add(new CumulativeCard(UUID.randomUUID(), ownerType, balance, travelPrice));
    }

    public void createCard(OwnerType ownerType, TravelsCountType travelsCountType) {
        cards.add(new MultiJourneyCard(UUID.randomUUID(), ownerType, travelsCountType));
    }

    public void createCard(OwnerType ownerType, DurationType durationType) {
        cards.add(new TemporaryCard(UUID.randomUUID(), ownerType, durationType));
    }

    public Card getCardById(UUID id) {
        for (Card card : cards) {
            if(card.getID() == id)
                return card;
        }
        return null;
    }

    public String getCardInfo(UUID id) {
        Card card = getCardById(id);
        return card.getID() + " " + card.getOwnerType().toString() + " " + card.toString() + "\n";
    }
}
