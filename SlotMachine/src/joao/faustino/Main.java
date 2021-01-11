package joao.faustino;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Symbol> symbolList = new ArrayList<>();
        Symbol eight = new Symbol("Eight", 0.05,14);
        Symbol nine = new Symbol("Nine", 0.08,12);
        Symbol ten = new Symbol("Ten", 0.1,12);
        Symbol jack = new Symbol("Jack", 0.15,12);
        Symbol queen = new Symbol("Queen", 0.25,12);
        Symbol king = new Symbol("King", 0.3,12);
        Symbol ace = new Symbol("Ace", 0.4,12);
        Symbol bonus = new Symbol("Bonus",4);
        Symbol wild = new Symbol("Wild",10);
        symbolList.add(bonus);
        symbolList.add(wild);
        symbolList.add(ace);
        symbolList.add(king);
        symbolList.add(jack);
        symbolList.add(queen);
        symbolList.add(ten);
        symbolList.add(nine);
        symbolList.add(eight);
        BonusSlot bonusSlot = new BonusSlot("Teste", symbolList);
        double balance = 1000000;
        Game game = new Game(balance, bonusSlot);

        double initialBalance = balance;
        int tentativa = 0;
        int retForPlayer = 0;
        int maxTries = 1000000;
        double averageMulti = 1;
        int totalMulti = 0;
        double biggestMulti = 0, biggestWin = 0;
        double averageWin = 1;
        int totalWins = 0;
        int bet = 1;
        int totalBonus = 0;


        while(tentativa++ < maxTries){
            Slot playingSlot = null;
            for (Slot slot : game.getSlots()) {
                if (slot.getSlotName().equals("Teste"))
                    playingSlot = slot;
            }
            System.out.println("\n"+"--------------------------------------------------------\n"+"Playing on "+ playingSlot.getSlotName() + " bet: " + bet +"€\n");
            game.play(bet, "Teste");
            System.out.println("FreeSpin number: " + game.getFreeSpins());
            System.out.println("Multiplier: " + game.getLastWon()/game.getLastBet());
            System.out.println("Won: " + game.getLastWon() +"€");
            System.out.println("Balance: "+ game.getBalance());

            if(playingSlot.getFreeSpins() >= 5)
                totalBonus++;

            if(game.getLastWon() > game.getLastBet())
                retForPlayer++;

            if(game.getBalance() > 200) {
                averageMulti = (averageMulti * totalMulti + game.getLastWon() / game.getLastBet()) / (totalMulti + 1);
                totalMulti++;

                averageWin = (averageWin * totalWins + game.getLastWon()) / (totalWins + 1);
                totalWins++;
            }

            if(biggestMulti < game.getLastWon()/game.getLastBet())
                biggestMulti = game.getLastWon()/game.getLastBet();

            if(biggestWin < game.getLastWon())
                biggestWin = game.getLastWon();

        }

        System.out.println("\n"+"--------------------------------------------------------");
        System.out.println("Return: " + retForPlayer + " of " + maxTries + " -> " + String.format("%.2f",(((double)retForPlayer/maxTries)*100)) + "%");
        System.out.println("Average Multiplier: " + String.format("%.2f",averageMulti) + "x");
        System.out.println("Biggest Multiplier: " + String.format("%.2f",biggestMulti) + "x");
        System.out.println("Average Win: " + String.format("%.2f",averageWin) + "€");
        System.out.println("Biggest Win: " + String.format("%.2f",biggestWin) + "€");
        System.out.println("Profit/Loss: " + String.format("%.2f",(game.getBalance() - initialBalance)) + "€" + " -> " + String.format("%.2f",((game.getBalance()/initialBalance)*100)) + "%");
        System.out.println("Bonus: " + totalBonus + " -> " + String.format("%.2f",(double)totalBonus/maxTries*100)+ "%");

    }
}


/*

        JFrame jFrame = new JFrame();
        jFrame.setTitle("Bulbasaur Casino");
        jFrame.setBounds(100,100, 400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());

        JTextArea text = new JTextArea(10, 20);
        TitledBorder borderTxt = BorderFactory.createTitledBorder("list");
        text.setBorder(borderTxt);
        text.setEditable(false);

        JScrollPane scrollText = new JScrollPane(text);
        scrollText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        container.add(scrollText, BorderLayout.CENTER);

        JMenuBar menu = new JMenuBar();

        JMenu slotsInfo = new JMenu("Slots");
        JMenuItem simpleSlot = new JMenuItem("Simple Slot");
        simpleSlot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                borderTxt.setTitle("Simple Slot");
                text.setText(sb.toString());
                text.setRows(10);
                text.repaint();
                jFrame.pack();
            }
        });
/*
        JMenuItem stations = new JMenuItem("Stations");
        stations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                borderTxt.setTitle("Stations");
                text.setText(sb.toString());
                text.setRows(18);
                text.setColumns(41);
                text.setSelectionStart(0);
                text.setSelectionEnd(0);
                text.repaint();
                jFrame.pack();
            }
        });

        JMenuItem crossingStations = new JMenuItem("Crossing stations");
        crossingStations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                borderTxt.setTitle("Crossing stations");

                text.setText(sb.toString());
                text.setRows(10);
                text.repaint();
                jFrame.pack();
            }
        });


        slotsInfo.add(simpleSlot);
       // slotsInfo.add(stations);
       // slotsInfo.add(crossingStations);
        menu.add(slotsInfo);


        JMenu lines = new JMenu("Lines");
        JMenuItem vermelha = new JMenuItem("Vermelha");
        vermelha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                borderTxt.setTitle("Vermelha");

                text.setText(sb.toString());
                text.setRows(14);
                text.repaint();
                jFrame.pack();
            }
        });
        JMenuItem amarela = new JMenuItem("Amarela");
        amarela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                borderTxt.setTitle("Amarela");

                text.setText(sb.toString());
                text.setRows(15);
                text.repaint();
                jFrame.pack();
            }
        });
        JMenuItem verde = new JMenuItem("Verde");
        verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                borderTxt.setTitle("Verde");

                text.setText(sb.toString());
                text.setRows(15);
                text.repaint();
                jFrame.pack();
            }
        });
        JMenuItem azul = new JMenuItem("Azul");
        azul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                borderTxt.setTitle("Azul");

                text.setText(sb.toString());
                text.setRows(20);
                text.repaint();
                jFrame.pack();
            }
        });
        lines.add(vermelha);
        lines.add(amarela);
        lines.add(verde);
        lines.add(azul);
        menu.add(lines);



        jFrame.setJMenuBar(menu);



        jFrame.pack();
        jFrame.setVisible(true);
        */