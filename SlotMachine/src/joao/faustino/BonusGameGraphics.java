package joao.faustino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BonusGameGraphics {

    int betIndex = 0;
    final double[] bet = {0.10, 0.20, 0.50, 0.75, 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 1500, 2000};
    private List<Symbol> symbolList = new ArrayList<>();
    boolean hasGame = false;
    boolean isLastSpin = false;
    boolean hugeMulti = false;
    int columnPrinted = 0;
    double totalWon = 0;

    BonusGameGraphics(){

        Symbol eight = new Symbol("Eight", 0.05,14);
        Symbol nine = new Symbol("Nine", 0.08,12);
        Symbol ten = new Symbol("Ten", 0.1,12);
        Symbol jack = new Symbol("Jack", 0.15,12);
        Symbol queen = new Symbol("Queen", 0.25,12);
        Symbol king = new Symbol("King", 0.3,12);
        Symbol ace = new Symbol("Ace", 0.4,12);
        Symbol bonus = new Symbol("Bonus",4);
        Symbol wild = new Symbol("Wild",10);

/*
        Symbol eight = new Symbol("Eight", 0.05,0);
        Symbol nine = new Symbol("Nine", 0.08,0);
        Symbol ten = new Symbol("Ten", 0.1,0);
        Symbol jack = new Symbol("Jack", 0.15,0);
        Symbol queen = new Symbol("Queen", 0.25,0);
        Symbol king = new Symbol("King", 0.3,0);
        Symbol ace = new Symbol("Ace", 0.4,0);
        Symbol bonus = new Symbol("Bonus",0);
        Symbol wild = new Symbol("Wild",100);
*/

        symbolList.add(bonus);
        symbolList.add(wild);
        symbolList.add(ace);
        symbolList.add(king);
        symbolList.add(jack);
        symbolList.add(queen);
        symbolList.add(ten);
        symbolList.add(nine);
        symbolList.add(eight);
        BonusSlot bonusSlot = new BonusSlot("BulbasaurSlot", symbolList);
        Game game = new Game(50, bonusSlot);


        JFrame gameSlot =new JFrame("Bulbasaur Casino");
        gameSlot.setBounds(100,100, 1200,700);
        gameSlot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel slotNameLabel = new JLabel();
        slotNameLabel.setText("Bonus Slot");
        slotNameLabel.setBounds(0, 0, 100, 20);

        JLabel clockCrazy = new JLabel();
        clockCrazy.setText("Bonus Slot");
        clockCrazy.setBounds(1080, 0, 100, 20);

        JButton playSlotButton = new JButton("Play Slot");
        playSlotButton.setBounds(1080,560,100, 100);

        JButton addBetButton = new JButton("Up");
        addBetButton.setBounds(1000, 560, 70, 50);

        JButton subBetButton = new JButton("Down");
        subBetButton.setBounds(1000, 610, 70, 50);

        JLabel balanceLabel = new JLabel("Balance €", SwingConstants.CENTER);
        balanceLabel.setBounds(900, 570, 100, 20);
        balanceLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel balanceValueLabel = new JLabel("" + game.getBalance(), SwingConstants.CENTER);
        balanceValueLabel.setBounds(900, 620, 100, 20);
        balanceValueLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));


        JLabel betLabel = new JLabel("Bet €", SwingConstants.CENTER);
        betLabel.setBounds(800, 570, 100, 20);
        betLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel betAmountLabel = new JLabel("" + bet[betIndex], SwingConstants.CENTER);
        betAmountLabel.setBounds(800, 620, 100, 20);
        betAmountLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));


        // por imagem no slotResult

        JLabel totalWonLabel = new JLabel("Total Won €", SwingConstants.CENTER);
        totalWonLabel.setBounds(350, 570, 150, 20);
        totalWonLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel totalWonValueLabel = new JLabel("0,00", SwingConstants.CENTER);
        totalWonValueLabel.setBounds(350, 620, 150, 20);
        totalWonValueLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel freeSpinsLabel = new JLabel("Free Spins", SwingConstants.CENTER);
        freeSpinsLabel.setBounds(500, 570, 150, 22);
        freeSpinsLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel freeSpinsValueLabel = new JLabel("0", SwingConstants.CENTER);
        freeSpinsValueLabel.setBounds(500, 620, 150, 20);
        freeSpinsValueLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel lastWonLabel = new JLabel("Last Won €", SwingConstants.CENTER);
        lastWonLabel.setBounds(650, 570, 150, 20);
        lastWonLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel lastWonValueLabel = new JLabel("0,00", SwingConstants.CENTER);
        lastWonValueLabel.setBounds(650, 620, 150, 20);
        lastWonValueLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel bigAnnouncementLabel = new JLabel("", SwingConstants.CENTER);
        bigAnnouncementLabel.setBounds(0, 100, 1200, 200);
        bigAnnouncementLabel.setFont(new Font("Serif", Font.PLAIN, 100));

        JLabel bigAnnouncementValueLabel = new JLabel("", SwingConstants.CENTER);
        bigAnnouncementValueLabel.setBounds(0, 200, 1200, 200);
        bigAnnouncementValueLabel.setFont(new Font("Serif", Font.PLAIN, 100));

        /*
        Primeira linha
         */
        JLabel zeroRowZeroColumn = new JLabel("", SwingConstants.CENTER);
        zeroRowZeroColumn.setBounds(0, 20, 220, 140);
        zeroRowZeroColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel zeroRowOneColumn = new JLabel("", SwingConstants.CENTER);
        zeroRowOneColumn.setBounds(240, 20, 220, 140);
        zeroRowOneColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel zeroRowTwoColumn = new JLabel("", SwingConstants.CENTER);
        zeroRowTwoColumn.setBounds(480, 20, 220, 140);
        zeroRowTwoColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel zeroRowThreeColumn = new JLabel("", SwingConstants.CENTER);
        zeroRowThreeColumn.setBounds(720, 20, 220, 140);
        zeroRowThreeColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel zeroRowFourColumn = new JLabel("", SwingConstants.CENTER);
        zeroRowFourColumn.setBounds(960, 20, 220, 140);
        zeroRowFourColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        /*
        Segunda linha
         */

        JLabel oneRowZeroColumn = new JLabel("", SwingConstants.CENTER);
        oneRowZeroColumn.setBounds(0, 180, 220, 140);
        oneRowZeroColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel oneRowOneColumn = new JLabel("", SwingConstants.CENTER);
        oneRowOneColumn.setBounds(240, 180, 220, 140);
        oneRowOneColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel oneRowTwoColumn = new JLabel("", SwingConstants.CENTER);
        oneRowTwoColumn.setBounds(480, 180, 220, 140);
        oneRowTwoColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel oneRowThreeColumn = new JLabel("", SwingConstants.CENTER);
        oneRowThreeColumn.setBounds(720, 180, 220, 140);
        oneRowThreeColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel oneRowFourColumn = new JLabel("", SwingConstants.CENTER);
        oneRowFourColumn.setBounds(960, 180, 220, 140);
        oneRowFourColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        /*
        Terceira linha
         */

        JLabel twoRowZeroColumn = new JLabel("", SwingConstants.CENTER);
        twoRowZeroColumn.setBounds(0, 340, 220, 140);
        twoRowZeroColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel twoRowOneColumn = new JLabel("", SwingConstants.CENTER);
        twoRowOneColumn.setBounds(240, 340, 220, 140);
        twoRowOneColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel twoRowTwoColumn = new JLabel("", SwingConstants.CENTER);
        twoRowTwoColumn.setBounds(480, 340, 220, 140);
        twoRowTwoColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel twoRowThreeColumn = new JLabel("", SwingConstants.CENTER);
        twoRowThreeColumn.setBounds(720, 340, 220, 140);
        twoRowThreeColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel twoRowFourColumn = new JLabel("", SwingConstants.CENTER);
        twoRowFourColumn.setBounds(960, 340, 220, 140);
        twoRowFourColumn.setFont(new Font("TimesRoman", Font.PLAIN, 20));


        //add to frame

        gameSlot.add(zeroRowZeroColumn);
        gameSlot.add(zeroRowOneColumn);
        gameSlot.add(zeroRowTwoColumn);
        gameSlot.add(zeroRowThreeColumn);
        gameSlot.add(zeroRowFourColumn);

        gameSlot.add(oneRowZeroColumn);
        gameSlot.add(oneRowOneColumn);
        gameSlot.add(oneRowTwoColumn);
        gameSlot.add(oneRowThreeColumn);
        gameSlot.add(oneRowFourColumn);

        gameSlot.add(twoRowZeroColumn);
        gameSlot.add(twoRowOneColumn);
        gameSlot.add(twoRowTwoColumn);
        gameSlot.add(twoRowThreeColumn);
        gameSlot.add(twoRowFourColumn);

        gameSlot.add(addBetButton);
        gameSlot.add(subBetButton);
        gameSlot.add(freeSpinsLabel);
        gameSlot.add(freeSpinsValueLabel);
        gameSlot.add(lastWonLabel);
        gameSlot.add(lastWonValueLabel);
        gameSlot.add(betLabel);
        gameSlot.add(betAmountLabel);
        gameSlot.add(balanceLabel);
        gameSlot.add(balanceValueLabel);
        gameSlot.add(totalWonValueLabel);
        gameSlot.add(totalWonLabel);
        gameSlot.add(clockCrazy);
        gameSlot.add(slotNameLabel);
        gameSlot.add(playSlotButton);
        gameSlot.add(bigAnnouncementLabel);
        gameSlot.add(bigAnnouncementValueLabel);

        gameSlot.setSize(1200,700);
        gameSlot.setLayout(null);
        gameSlot.setVisible(true);
        gameSlot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        int delay1 = 5000; //milliseconds
        ActionListener announcement = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hugeMulti){
                    zeroRowZeroColumn.setIcon(null);
                    oneRowZeroColumn.setIcon(null);
                    twoRowZeroColumn.setIcon(null);
                    zeroRowOneColumn.setIcon(null);
                    oneRowOneColumn.setIcon(null);
                    twoRowOneColumn.setIcon(null);
                    zeroRowTwoColumn.setIcon(null);
                    oneRowTwoColumn.setIcon(null);
                    twoRowTwoColumn.setIcon(null);
                    zeroRowThreeColumn.setIcon(null);
                    oneRowThreeColumn.setIcon(null);
                    twoRowThreeColumn.setIcon(null);
                    zeroRowFourColumn.setIcon(null);
                    oneRowFourColumn.setIcon(null);
                    twoRowFourColumn.setIcon(null);

                    double multiplier = totalWon/game.getLastBet();

                    if( multiplier > 10) {
                        bigAnnouncementLabel.setText("HUGE WIN");
                    }else if (multiplier > 100){
                        bigAnnouncementLabel.setText("EXTREME WIN");
                    }else
                        bigAnnouncementLabel.setText("BIG WIN");

                    bigAnnouncementValueLabel.setText("" + String.format("%.2f",totalWon) + "€");
                    totalWon = 0;
                    isLastSpin = false;
                    hugeMulti = false;
                }
            }
        };
        new Timer(delay1, announcement).start();


        // New timer which works!
        int delay = 500; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                Slot playingSlot = null;
                for (Slot slot : game.getSlots()) {
                    if (slot.getSlotName().equals("BulbasaurSlot"))
                        playingSlot = slot;
                }


                if(hasGame) {
                    switch (columnPrinted) {
                        case 0:
                            zeroRowZeroColumn.setIcon(null);
                            oneRowZeroColumn.setIcon(null);
                            twoRowZeroColumn.setIcon(null);
                            zeroRowOneColumn.setIcon(null);
                            oneRowOneColumn.setIcon(null);
                            twoRowOneColumn.setIcon(null);
                            zeroRowTwoColumn.setIcon(null);
                            oneRowTwoColumn.setIcon(null);
                            twoRowTwoColumn.setIcon(null);
                            zeroRowThreeColumn.setIcon(null);
                            oneRowThreeColumn.setIcon(null);
                            twoRowThreeColumn.setIcon(null);
                            zeroRowFourColumn.setIcon(null);
                            oneRowFourColumn.setIcon(null);
                            twoRowFourColumn.setIcon(null);

                            columnPrinted++;
                            break;
                        case 1:
                            zeroRowZeroColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(0, 0)));
                            oneRowZeroColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(1, 0)));
                            twoRowZeroColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(2, 0)));

                            columnPrinted++;
                            break;
                        case 2:
                            zeroRowOneColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(0, 1)));
                            oneRowOneColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(1, 1)));
                            twoRowOneColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(2, 1)));

                            columnPrinted++;
                            break;
                        case 3:
                            zeroRowTwoColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(0, 2)));
                            oneRowTwoColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(1, 2)));
                            twoRowTwoColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(2, 2)));

                            columnPrinted++;
                            break;
                        case 4:
                            zeroRowThreeColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(0, 3)));
                            oneRowThreeColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(1, 3)));
                            twoRowThreeColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(2, 3)));

                            columnPrinted++;
                            break;
                        case 5:
                            zeroRowFourColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(0, 4)));
                            oneRowFourColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(1, 4)));
                            twoRowFourColumn.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(2, 4)));

                            lastWonValueLabel.setText("" + String.format("%.2f",game.getLastWon()));
                            balanceValueLabel.setText("" + String.format("%.2f",game.getBalance()));
                            freeSpinsValueLabel.setText("" + game.getFreeSpins());

                            if(game.getFreeSpins() > 0){
                                System.out.println("FreeSpin: " + game.getFreeSpins());
                                totalWon += game.getLastWon();
                                System.out.println("" + game.getFreeSpins() + " e é o lastSpin?" + isLastSpin);

                                if(game.getFreeSpins() == 1)
                                    isLastSpin = true;
                                else
                                    isLastSpin = false;

                            }else if (isLastSpin){
                                hugeMulti = true;

                            }else {
                                totalWon = 0;
                                isLastSpin = false;
                            }

                            totalWonValueLabel.setText("" + String.format("%.2f", totalWon));

                            columnPrinted = 0;
                            hasGame = false;
                            break;
                    }
                }

                String date = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date(System.currentTimeMillis()));
                clockCrazy.setText(date);

            }
        };
        new Timer(delay, taskPerformer).start();



        //action listener
        addBetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(game.getFreeSpins() == 0) {
                    if (betIndex == 15)
                        return;
                    betIndex++;
                    betAmountLabel.setText("" + bet[betIndex]);
                }
            }
        });

        //action listener
        subBetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(game.getFreeSpins() == 0) {
                    if (betIndex == 0)
                        return;
                    betIndex--;
                    betAmountLabel.setText("" + bet[betIndex]);
                }
            }
        });

        //action listener
        playSlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(hasGame) return;

                if (bet[betIndex] > game.getBalance())
                    return;

                if(game.getFreeSpins() == 0)
                    balanceValueLabel.setText("" + String.format("%.2f",game.getBalance()-bet[betIndex]));

                bigAnnouncementValueLabel.setText("");
                bigAnnouncementLabel.setText("");
                hugeMulti = false;

                game.play(bet[betIndex], "BulbasaurSlot");

                Slot playingSlot = null;
                for (Slot slot : game.getSlots()) {
                    if (slot.getSlotName().equals("BulbasaurSlot"))
                        playingSlot = slot;
                }

                if (playingSlot != null) {
                    hasGame = true;
                }
            }
        });
    }

    public ImageIcon chooseIcon(String name){
        switch (name){
            case "Ace":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\aceBonus.png");
            case "King":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\kingBonus.png");
            case "Queen":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\queenBonus.png");
            case "Jack":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\jackBonus.png");
            case "Ten":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\tenBonus.png");
            case "Nine":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\nineBonus.png");
            case "Eight":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\eightBonus.png");
            case "Bonus":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\bulbasaurBonus.png");
            case "Wild":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\wildBonusv2.png");
        }
        return null;
    }


    public static void main(String[] args) {
        new BonusGameGraphics();
    }
}
