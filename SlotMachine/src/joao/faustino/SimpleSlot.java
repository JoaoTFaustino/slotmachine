package joao.faustino;

import java.util.ArrayList;
import java.util.List;

public class SimpleSlot implements Slot{
    private List<Symbol> symbolList;
    private BoardGenerator board;
    private String name;
    private final int row = 1;
    private final int column = 3;

    /**
     * Creates a SimpleSlot with only five different Symbols and no bonuses.
     * 1x3 (row, column)
     */
    SimpleSlot(String slotName, List<Symbol> symbolList){
        this.name = slotName;
        this.symbolList = symbolList;
        board = new BoardGenerator(row,column,this.symbolList);
    }

    @Override
    public double slotGenerator(double bet){
        board.generatorStart();
        return (double)bet * getMultiplier();
    }

    @Override
    public String getSlotName(){
        return name;
    }

    @Override
    public double slotFreeSpin(double bet) {
        return 0;
    }

    @Override
    public String showPreviousBoard(){
        return board.printBoard();
    }

    /**
     * Returns the multiplier in a given row
     */
    private double getMultiplierPerRow(int row){
        double multiplier = 0;
        List<Symbol> symbolList = new ArrayList<>();

        for(int i = 0; i < board.getBoardColumns(); i++){
            symbolList.add(board.getSymbolInBoard(row,i));
        }

        int column = 0;
        while((column + 1) < board.getBoardColumns()) {
            if (symbolList.get(column).compareTo(symbolList.get(column + 1))) {
                if((column + 1) == board.getBoardColumns()-1){
                    multiplier = multiplier * 2;
                }else {
                    multiplier += symbolList.get(column).getPoints() + symbolList.get(column + 1).getPoints();
                }
                column++;
            } else
                break;
        }
        return multiplier;
    }

    @Override
    public double getMultiplier(){
        double multiplier = 0;
        for(int i = 0; i < board.getBoardRows(); i++){
            multiplier += getMultiplierPerRow(i);
        }
        return multiplier;
    }

    @Override
    public List<Symbol> getSymbolList(){
        return symbolList;
    }

    public Board getBoard(){
        return board;
    }

    @Override
    public int getFreeSpins(){
        return 0;
    }

    @Override
    public boolean hasFreeSpins() {
        return false;
    }
}
