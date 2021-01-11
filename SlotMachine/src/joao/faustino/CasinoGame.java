package joao.faustino;

import java.util.List;

public interface CasinoGame {
    String play(double bet, String slotName);
    double getBalance();
    double getLastBet();
    double getLastWon();
    List<Slot> getSlots();
}
