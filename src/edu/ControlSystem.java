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

public class ControlSystem {
    private  static ControlSystem instance;
    private ArrayList<Card> cards = new ArrayList<>();
    public ArrayList<Turnstile> turnstiles = new ArrayList<>();
    public ArrayList<Pass> passes = new ArrayList<>();
    public int travelPrice = 4;
    private static int turnstilesCount = 0;
  
    private ControlSystem() {
    }

    public static ControlSystem getInstance() {
        if(instance == null) {
            instance = new ControlSystem();
        }
        return instance;
    }

    public void createTurnstile() {
        turnstiles.add(new Turnstile(this, turnstilesCount++));
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

    public Card getCardByIndex(int index){
        return cards.get(index);
    }
}
