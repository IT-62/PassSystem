package edu;

import java.util.Date;
import java.util.UUID;

public class Pass {
    private Date passDate;
    private boolean passed;
    private int turnstileId;
    private UUID cardId;
    private ContolSystem contolSystem;

    public Pass(boolean passed, int turnstileId, UUID cardId, ContolSystem contolSystem) {
        this.passed = passed;
        this.turnstileId = turnstileId;
        this.cardId = cardId;
        passDate = new Date(new Date().getTime());
        this.contolSystem = contolSystem;
    }

    public Date getPassDate() {
        return passDate;
    }

    public boolean isPassed() {
        return passed;
    }

    public int getTurnstileId() {
        return turnstileId;
    }

    public UUID getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        return contolSystem.getCardInfo(cardId) + " " + passed + " " + turnstileId + " " + cardId.toString() + "\n";
    }
}
