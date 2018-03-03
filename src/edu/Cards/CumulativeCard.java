package edu.Cards;

import edu.options.OwnerType;

import java.util.UUID;

public class CumulativeCard extends Card {
    private int balance;
    private int travelPrice;

    public CumulativeCard(UUID id, OwnerType ownerType, int balance, int travelPrice) {
        super(id, ownerType);
        this.balance = balance;
        this.travelPrice = travelPrice;
    }
    //SetBalance provides extra freedom. I guess...
    public void replenish(int amount){
        balance += amount;
    }
    public boolean withdraw() {
        if(balance >= travelPrice){
            balance -= travelPrice;
            return true;
        }
        return false;
    }
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean verify() {
        return withdraw();
    }
}
