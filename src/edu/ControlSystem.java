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
    private enum CardType{
        CUMULATIVE, MULTIJOURNEY, TEMPORARY
    }
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

    public void createCard(int balance) {
        cards.add(new CumulativeCard(UUID.randomUUID(), balance, travelPrice));
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
        return "Card ID: " + card.getID() + "\n" +
               "Owner type: " + card.getOwnerType().toString() + "\n" +
               card.toString();
    }

    public Card getCardByIndex(int index){
        return cards.get(index);
    }

    public ArrayList<CumulativeCard> getCumulativeCardList(){
        ArrayList<CumulativeCard> cumulativeCardsList = new ArrayList<>();
        for(Card card : cards) {
           if(card instanceof CumulativeCard) cumulativeCardsList.add((CumulativeCard)card);
        }
        return null;
    }

    public ArrayList<TemporaryCard> getTemporaryCard(){
        ArrayList<TemporaryCard> temporaryCardsList = new ArrayList<>();
        for(Card card : cards) {
            if(card instanceof TemporaryCard) temporaryCardsList.add((TemporaryCard)card);
        }
        return null;
    }

    public ArrayList<MultiJourneyCard> getMultiJourneyCard(){
        ArrayList<MultiJourneyCard> multiJourneyCardsList = new ArrayList<>();
        for(Card card : cards) {
            if(card instanceof MultiJourneyCard) multiJourneyCardsList.add((MultiJourneyCard)card);
        }
        return null;
    }

    public int getCountOfTries(){
        return passes.size();
    }

    public int getCountOfPasses(){
        int ans = 0;
        for (Pass pass : passes) {
            if(pass.isPassed()) ans++;
        }
        return ans;
    }

    public int getCountOfFales(){
        return passes.size() - getCountOfPasses();
    }

    public int getCountOfTriesOfCard(String type, String durType, String owType){
        int countOfPasses = 0;
        CardType cardType = CardType.valueOf(type);
        DurationType durationType = DurationType.valueOf(durType);
        OwnerType ownerType = OwnerType.valueOf(owType);
        switch (cardType){
            case CUMULATIVE:{
                for (Pass pass : passes) {
                    if(getCardById(pass.getCardId()) instanceof CumulativeCard) countOfPasses++;
                }
            }
            case TEMPORARY:{
                switch (durationType){
                    case MONTH:{
                        switch (ownerType){
                            case PUPIL:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.PUPIL) countOfPasses++;
                                }
                            }
                            case DEFAULT:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.DEFAULT) countOfPasses++;
                                }
                            }
                            case STUDENT:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.STUDENT) countOfPasses++;
                                }
                            }
                        }
                    }
                    case TEN_DAYS:{
                        switch (ownerType){
                            case PUPIL:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.PUPIL) countOfPasses++;
                                }
                            }
                            case DEFAULT:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.DEFAULT) countOfPasses++;
                                }
                            }
                            case STUDENT:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.STUDENT) countOfPasses++;
                                }
                            }
                        }
                    }
                }
            }
            case MULTIJOURNEY:{
                switch (durationType) {
                    case MONTH: {
                        switch (ownerType) {
                            case PUPIL: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.PUPIL)
                                        countOfPasses++;
                                }
                            }
                            case DEFAULT: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.DEFAULT)
                                        countOfPasses++;
                                }
                            }
                            case STUDENT: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.STUDENT)
                                        countOfPasses++;
                                }
                            }
                        }
                    }
                    case TEN_DAYS: {
                        switch (ownerType) {
                            case PUPIL: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.PUPIL)
                                        countOfPasses++;
                                }
                            }
                            case DEFAULT: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.DEFAULT)
                                        countOfPasses++;
                                }
                            }
                            case STUDENT: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.STUDENT)
                                        countOfPasses++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return countOfPasses;
    }


    public int getCountOfPassesOfCard(String type, String durType, String owType){
        int countOfPasses = 0;
        CardType cardType = CardType.valueOf(type);
        DurationType durationType = DurationType.valueOf(durType);
        OwnerType ownerType = OwnerType.valueOf(owType);
        switch (cardType){
            case CUMULATIVE:{
                for (Pass pass : passes) {
                    if(getCardById(pass.getCardId()) instanceof CumulativeCard) countOfPasses++;
                }
            }
            case TEMPORARY:{
                switch (durationType){
                    case MONTH:{
                        switch (ownerType){
                            case PUPIL:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.PUPIL
                                            && pass.isPassed()) countOfPasses++;
                                }
                            }
                            case DEFAULT:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.DEFAULT
                                            && pass.isPassed()) countOfPasses++;
                                }
                            }
                            case STUDENT:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.STUDENT
                                            && pass.isPassed()) countOfPasses++;
                                }
                            }
                        }
                    }
                    case TEN_DAYS:{
                        switch (ownerType){
                            case PUPIL:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.PUPIL
                                            && pass.isPassed()) countOfPasses++;
                                }
                            }
                            case DEFAULT:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.DEFAULT
                                            && pass.isPassed()) countOfPasses++;
                                }
                            }
                            case STUDENT:{
                                for (Pass pass : passes) {
                                    if(getCardById(pass.getCardId()) instanceof TemporaryCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.STUDENT
                                            && pass.isPassed()) countOfPasses++;
                                }
                            }
                        }
                    }
                }
            }
            case MULTIJOURNEY:{
                switch (durationType) {
                    case MONTH: {
                        switch (ownerType) {
                            case PUPIL: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.PUPIL
                                            && pass.isPassed())
                                        countOfPasses++;
                                }
                            }
                            case DEFAULT: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.DEFAULT
                                            && pass.isPassed())
                                        countOfPasses++;
                                }
                            }
                            case STUDENT: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.MONTH
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.STUDENT
                                            && pass.isPassed())
                                        countOfPasses++;
                                }
                            }
                        }
                    }
                    case TEN_DAYS: {
                        switch (ownerType) {
                            case PUPIL: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.PUPIL
                                            && pass.isPassed())
                                        countOfPasses++;
                                }
                            }
                            case DEFAULT: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.DEFAULT
                                            && pass.isPassed())
                                        countOfPasses++;
                                }
                            }
                            case STUDENT: {
                                for (Pass pass : passes) {
                                    if (getCardById(pass.getCardId()) instanceof MultiJourneyCard
                                            && ((TemporaryCard) getCardById(pass.getCardId())).getDurationType() == DurationType.TEN_DAYS
                                            && getCardById(pass.getCardId()).getOwnerType() == OwnerType.STUDENT
                                            && pass.isPassed())
                                        countOfPasses++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return countOfPasses;
    }

}
