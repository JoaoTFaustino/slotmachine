package joao.faustino;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameGraphics {
    int betIndex = 0;
    final double[] bet = {0.10, 0.20, 0.50, 0.75, 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 1500, 2000};
    private List<Symbol> symbolList = new ArrayList<>();


    GameGraphics(){

        Symbol bulbasaur = new Symbol("Bulbasaur", 1);
        Symbol charmander = new Symbol("Charmander", 1);
        Symbol squirtle = new Symbol("Squirtle", 1);
        Symbol mew = new Symbol("Mew", 1);
        Symbol pokeball = new Symbol("Pokeball", 1);
        symbolList.add(bulbasaur);
        symbolList.add(charmander);
        symbolList.add(squirtle);
        symbolList.add(mew);
        symbolList.add(pokeball);
        SimpleSlot simpleSlot = new SimpleSlot("BulbasaurSlot", symbolList);
        Game game = new Game(10000, simpleSlot);


        JFrame gameSlot =new JFrame("Bulbasaur Casino");
        gameSlot.setBounds(100,100, 400, 400);
        gameSlot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton playSlotButton = new JButton("Play Slot");
        playSlotButton.setBounds(0,330,400, 30);

        JButton addBetButton = new JButton("Up");
        addBetButton.setBounds(115, 300, 50, 21);

        JButton subBetButton = new JButton("Dn");
        subBetButton.setBounds(165, 300, 50, 21);


        JLabel slotNameLabel = new JLabel();
        slotNameLabel.setText("Simple Slot");
        slotNameLabel.setBounds(0, 0, 100, 20);


        JLabel balanceLabel = new JLabel();
        balanceLabel.setText("Balance: " + game.getBalance() + "€");
        balanceLabel.setBounds(280, 0, 100, 20);

        // por imagem no slotResult

        JLabel slotResultLabel = new JLabel("", SwingConstants.CENTER);
        slotResultLabel.setBounds(0, 150, 400, 40);
        slotResultLabel.setFont(new Font("Serif", Font.PLAIN, 30));


        JLabel firstSlotResultLabel = new JLabel("", SwingConstants.CENTER);
        firstSlotResultLabel.setBounds(0, 20, 130, 250);
        //firstSlotResultLabel.setIcon(new ImageIcon("C:\\Users\\joaot\\Desktop\\SlotMachine\\src\\mewEdit.png"));

        JLabel secondSlotResultLabel = new JLabel("", SwingConstants.CENTER);
        secondSlotResultLabel.setBounds(130, 20, 130, 250);
       // secondSlotResultLabel.setIcon(new ImageIcon("C:\\Users\\joaot\\Desktop\\SlotMachine\\src\\pokeballEdit.png"));

        JLabel thirdSlotResultLabel = new JLabel("", SwingConstants.CENTER);
        thirdSlotResultLabel.setBounds(260, 20, 130, 250);
       // thirdSlotResultLabel.setIcon(new ImageIcon("C:\\Users\\joaot\\Desktop\\SlotMachine\\src\\bulbasaurEdit.png"));


        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setBounds(0, 20, 400, 40);
        resultLabel.setFont(new Font("Serif", Font.PLAIN, 30));


        JLabel betLabel = new JLabel();
        betLabel.setText("Bet: ");
        betLabel.setBounds(0, 300, 50, 20);
        betLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel betAmountLabel = new JLabel();
        betAmountLabel.setText("" + bet[betIndex] + "€");
        betAmountLabel.setBounds(40, 300, 100, 20);
        betAmountLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));


        JLabel lastWonLabel = new JLabel();
        lastWonLabel.setText("Last Won: ");
        lastWonLabel.setBounds(0, 270, 300, 20);
        lastWonLabel.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        //add to frame
        gameSlot.add(firstSlotResultLabel);
        gameSlot.add(secondSlotResultLabel);
        gameSlot.add(thirdSlotResultLabel);
        gameSlot.add(addBetButton);
        gameSlot.add(subBetButton);
        gameSlot.add(resultLabel);
        gameSlot.add(lastWonLabel);
        gameSlot.add(betLabel);
        gameSlot.add(betAmountLabel);
        gameSlot.add(balanceLabel);
        gameSlot.add(slotResultLabel);
        gameSlot.add(slotNameLabel);
        gameSlot.add(playSlotButton);
        gameSlot.setSize(400,400);
        gameSlot.setLayout(null);
        gameSlot.setVisible(true);
        gameSlot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        //action listener
        addBetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(betIndex == 15)
                    return;
                betIndex++;
                betAmountLabel.setText("" + bet[betIndex] + "€");
            }
        });

        //action listener
        subBetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(betIndex == 0)
                    return;
                betIndex--;
                betAmountLabel.setText("" + bet[betIndex] + "€");
            }
        });


        //action listener
        playSlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (bet[betIndex] > game.getBalance())
                    return;

                //slotResultLabel.setText(game.play(bet[betIndex]));
                game.play(bet[betIndex], "BulbasaurSlot");
                balanceLabel.setText("Balance: " + game.getBalance() + "€");
                lastWonLabel.setText("Last Won: " + game.getLastWon() + "€");

                Slot playingSlot = null;
                for (Slot slot : game.getSlots()) {
                    if (slot.getSlotName().equals("BulbasaurSlot"))
                        playingSlot = slot;
                }

                if (playingSlot != null) {
                    firstSlotResultLabel.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(0, 0)));
                    secondSlotResultLabel.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(0, 1)));
                    thirdSlotResultLabel.setIcon(chooseIcon(playingSlot.getBoard().getSymbolNameInBoard(0, 2)));

                    if (game.getLastWon() > 0) {
                        resultLabel.setText("You Won!");
                    } else {
                        resultLabel.setText("You Lost!");
                    }
                }
            }
        });



    }

    public ImageIcon chooseIcon(String name){
        switch (name){
            case "Bulbasaur":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\bulbasaurEdit.png");
            case "Charmander":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\charmanderEdit.png");
            case "Squirtle":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\squirtleEdit.png");
            case "Mew":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\mewEdit.png");
            case "Pokeball":
                return new ImageIcon("C:\\Users\\joaot\\Desktop\\Random\\SlotMachine\\src\\pokeballEdit.png");
        }
        return null;
    }


    public static void main(String[] args) {
        new GameGraphics();
    }
}
