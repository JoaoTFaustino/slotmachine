package joao.faustino;

import java.util.ArrayList;
import java.util.List;

public class Game implements CasinoGame{
    private double balance;
    private double lastBet;
    private double lastWon;
    private int freeSpins = 0;
    private List<Slot> slotsList = new ArrayList<>();

    /**
     * Creates a game with a Slot and a start balance
     */
    Game(double balance, Slot... slots){
        for(Slot slot : slots)
            slotsList.add(slot);
        this.balance = balance;
    }

    /**
     * Bets the given value
     * and returns the board's state
     */
    public String play(double bet, String slotName){
        if(bet > balance || balance == 0){
            return "No balance";
        }

        Slot playingSlot = null;
        for(Slot slot : slotsList){
            if(slot.getSlotName().equals(slotName))
                playingSlot = slot;
        }
        if(playingSlot == null)
            return "Slot unavailable";

        if(playingSlot.hasFreeSpins()){
            System.out.println("Tou na FreeSpin: "+ freeSpins);
            lastBet = bet;
            lastWon = playingSlot.slotFreeSpin(bet);
            balance = balance + lastWon;
        }else{
            lastBet = bet;
            lastWon = playingSlot.slotGenerator(bet);
            balance = balance - bet + lastWon;
        }

        freeSpins = playingSlot.getFreeSpins();
        return "Success";
    }

    /**
     * Returns the actual balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the value of the last bet
     */
    public double getLastBet(){
        return lastBet;
    }

    /**
     * Returns the value of the last prize won
     */
    public double getLastWon() {
        return lastWon;
    }

    /**
     * Returns the Slot List in the game
     */
    public List<Slot> getSlots(){
        return slotsList;
    }

    public int getFreeSpins(){
        return freeSpins;
    }


}
