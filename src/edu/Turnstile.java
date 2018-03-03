package edu;

import edu.Cards.CumulativeCard;
import edu.Cards.MultiJourneyCard;
import edu.Cards.TemporaryCard;

public class Turnstile {
    private ContolSystem contolSystem;
    private int id;
    public Turnstile(ContolSystem contolSystem, int id) {
        this.contolSystem = contolSystem;
        this.id = id;
    }

    public boolean acceptPass(CumulativeCard cumulativeCard) {
        boolean passes = cumulativeCard.verify();
        contolSystem.passes.add(new Pass(passes, id, cumulativeCard.getID(), contolSystem));
        if(passes) {
            return true;
        }
        return false;
    }
    public boolean acceptPass(MultiJourneyCard multiJourneyCard) {
        boolean passes = multiJourneyCard.verify();
        contolSystem.passes.add(new Pass(passes, id, multiJourneyCard.getID(), contolSystem));
        if(passes){
            return true;
        }
        return false;
    }
    public boolean acceptPass(TemporaryCard temporaryCard) {
        boolean passes = temporaryCard.verify();
        contolSystem.passes.add(new Pass(passes, id, temporaryCard.getID(), contolSystem));
        if(passes){
            return true;
        }
        return false;
    }
}
