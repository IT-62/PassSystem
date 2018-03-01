package edu.Cards;

import java.util.UUID;

public class CumulativeCard extends Card {
    private int balance;
    private int travelPrice;

    public CumulativeCard(UUID id, int balance, int travelPrice) {
        this.balance = balance;
        this.travelPrice = travelPrice;
    }
    //SetBalance provides extra freedom. I guess...
    public void replenish(int amount){
        balance+=amount;
    }
    public boolean withdraw(){
        if(balance >= travelPrice){
            balance-=travelPrice;
            return true;
        }
        return false;
    }

    @Override
    public boolean verify() {
        if(withdraw()) return true;
        return false;
    }
}
