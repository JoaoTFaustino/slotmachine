package joao.faustino;

import java.util.List;

public interface Slot {

    /**
     * Returns the Slots' name
     */
    String getSlotName();

    /**
     * Generates a slot and returns the prize won
     */
    double slotFreeSpin(double bet);

    /**
     * Generates a slot and returns the prize won
     */
    double slotGenerator(double bet);

    /**
     * Returns a String the previous state of the board
     */
    String showPreviousBoard();

    /**
     * Returns the multiplier of the board
     */
    double getMultiplier();

    /**
     * Returns the list of Symbols
     */
    List<Symbol> getSymbolList();

    /**
     * Returns the board
     */
    Board getBoard();

    int getFreeSpins();

    boolean hasFreeSpins();
}
