package joao.faustino;

import java.util.ArrayList;
import java.util.List;

public class BonusSlot implements Slot{
    private final List<Symbol> symbolList;
    private BonusBoardGenerator board;
    private String name;
    private final int row = 3;
    private final int column = 5;
    private final double threeRatio = 0.4;
    private final double fourRatio = 0.7;
    private final double fiveRatio = 1;
    private int freeSpins = 0;

    BonusSlot(String slotName, List<Symbol> symbolList) {
        this.name = slotName;
        this.symbolList = symbolList;
        board = new BonusBoardGenerator(row, column, this.symbolList);
    }

    @Override
    public String getSlotName() {
        return name;
    }

    private int getBonusSpins(){
        int bonusSpins = 0;
        int numberOfBonus = 0;
        for(int i = 0; i < board.getBoardRows(); i++){
            for(int j = 0; j < board.getBoardColumns(); j++){
                if(board.getSymbolInBoard(i,j).isSymbolBonus()){
                    numberOfBonus++;
                }
            }
        }
        if(numberOfBonus >= 3){
            bonusSpins = numberOfBonus + 2;
        }

        return bonusSpins;
    }

    private void setBonusSymbols(double points){
        for(Symbol symbol : symbolList){
            symbol.setBonusPoints(points);
        }
    }

    @Override
    public boolean hasFreeSpins(){
        if(freeSpins > 0) return true;
        return false;
    }

    @Override
    public double slotFreeSpin(double bet){
        if(freeSpins > 0){
            setBonusSymbols(0.8);
            double prizeWon = slotGenerator(bet);
            setBonusSymbols(-0.8);
            freeSpins--;
            return prizeWon;
        }
        return -1;
    }

    @Override
    public double slotGenerator(double bet) {

        board.generatorStart();
        System.out.println(board.printBoard()+"\n");
        double prizeWon = bet * getMultiplier();

        freeSpins += getBonusSpins();

        /*
        int freeSpinCount = 1;
        while(freeSpinCount <= freeSpins){
            setBonusSymbols(0.8);
            System.out.println("FreeSpin: " + freeSpinCount + " of " + freeSpins);
            board.generatorStart();
            prizeWon+= bet*getMultiplier();
            System.out.println(board.printBoard()+"\n");
            System.out.println("Multi: " + prizeWon/bet);
            freeSpins += getBonusSpins();
            freeSpinCount++;
            setBonusSymbols(-0.8);
        }
         */

        return prizeWon;
    }

    @Override
    public String showPreviousBoard() {
        return board.printBoard();
    }

    /**
     *  Returns the next equal symbols
     *  straight
     *  or diagonal
     */
    private List<Matrix> getSymbolEqual(int row, int column, Symbol symbol){
        if(column == board.getBoardColumns() - 1)
            return null;

        List<Matrix> cntEqual = new ArrayList<>();
        if(symbol.isSymbolBonus())
            return null;

        if(row == 0){
            if(symbol.compareMultiplier(board.getSymbolInBoard(row,column+1))){
                cntEqual.add(new Matrix(row, column+1));
            }
            if(symbol.compareMultiplier(board.getSymbolInBoard(row+1,column+1))){
                cntEqual.add(new Matrix(row+1, column+1));
            }
        }else if(row == board.getBoardRows() - 1){
            if(symbol.compareMultiplier(board.getSymbolInBoard(row-1,column+1))){
                cntEqual.add(new Matrix(row-1, column+1));
            }
            if(symbol.compareMultiplier(board.getSymbolInBoard(row,column+1))){
                cntEqual.add(new Matrix(row, column+1));
            }
        }else{
            if(symbol.compareMultiplier(board.getSymbolInBoard(row-1,column+1))){
                cntEqual.add(new Matrix(row-1, column+1));
            }
            if(symbol.compareMultiplier(board.getSymbolInBoard(row,column+1))){
                cntEqual.add(new Matrix(row, column+1));
            }
            if(symbol.compareMultiplier(board.getSymbolInBoard(row+1,column+1))){
                cntEqual.add(new Matrix(row+1, column+1));
            }
        }
        return cntEqual;
    }

    /**
     *  Remove Duplicates from a List
     */
    private List<Combinations> getNoDuplicates(List<Combinations> largerList, List<Combinations> smallerList){
        List<Combinations> retList = new ArrayList<>();

        for(int i = 0; i < smallerList.size(); i++){
            boolean single = true;
            for(int j = 0; j < largerList.size(); j++) {
                if (smallerList.get(i).compareCombinations(largerList.get(j))) {
                    single = false;
                }
            }
            if(single){
                retList.add(smallerList.get(i));
            }
        }

        return retList;
    }

    /**
     *  Return the multiplier of a combination
     */
    private double getCombinationMultiplier(List<Combinations> combinationsList, double ratio){
        double multiplier = 0;
        for(Combinations oneCombination : combinationsList){
            double singleMultiplier = 1;
            List<Matrix> oneWay = oneCombination.getMatrix();
            for(int i = 0; i < oneWay.size() - 1; i++){
                if(oneWay.get(i).row == oneWay.get(i+1).row)
                    singleMultiplier += 1;
                else
                    singleMultiplier += 0.8;
            }
            double symbolMultiplier = singleMultiplier * oneCombination.getSymbol().getPoints() * ratio;
            multiplier += symbolMultiplier;
            //System.out.println(oneCombination.fullCombination() + "Multi:" + singleMultiplier + " * " + oneCombination.getSymbol().getPoints() + " * " + ratio + " = " + symbolMultiplier);
        }
        return multiplier;
    }

    /**
     * Returns the multiplier on the board
     */
    @Override
    public double getMultiplier(){
        double totalMultiplier = 0;  // multiplicador total

        List<Combinations> threeCombinations = new ArrayList<>();
        List<Combinations> fourCombinations = new ArrayList<>();
        List<Combinations> fiveCombinations = new ArrayList<>();

        /*
        Future Work: Fzr um metodo para melhorar isto
         */
        for(int i = 0; i < board.getBoardRows(); i++) {
            List<Matrix> columnZero = getSymbolEqual(i, 0, board.getSymbolInBoard(i,0));
            if (columnZero != null) {
                for(Matrix zero : columnZero){
                    Symbol symbol = board.getSymbolInBoard(zero.row,zero.column);

                    if(symbol.isSymbolWild()){
                        symbol = board.getSymbolInBoard(i,0);
                    }

                    List<Matrix> columnOne = getSymbolEqual(zero.row, zero.column,symbol);
                    if(columnOne != null){
                        for(Matrix one : columnOne) {
                            if(!symbol.isSymbolWild())
                                threeCombinations.add(new Combinations(symbol,new Matrix(i,0), zero, one));

                            Symbol symbol2 = board.getSymbolInBoard(one.row,one.column);

                            if(symbol2.isSymbolWild()){
                                symbol2 = symbol;
                            }

                            List<Matrix> columnTwo = getSymbolEqual(one.row, one.column,symbol2);

                            if(columnTwo != null){
                                for(Matrix two : columnTwo){
                                    if(!symbol2.isSymbolWild())
                                        fourCombinations.add(new Combinations(symbol2,new Matrix(i,0), zero, one, two));

                                    Symbol symbol3 = board.getSymbolInBoard(two.row,two.column);

                                    if(symbol3.isSymbolWild()){
                                        symbol3 = symbol2;
                                    }

                                    List<Matrix> columnThree = getSymbolEqual(two.row, two.column,symbol3);

                                    if(columnThree != null){
                                        for(Matrix three : columnThree){
                                            if(!symbol3.isSymbolWild())
                                                fiveCombinations.add(new Combinations(symbol3,new Matrix(i,0), zero, one, two, three));

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        List<Combinations> updatedThree, updatedFour, updatedFive;

        updatedThree = getNoDuplicates(fourCombinations, threeCombinations);
        updatedFour = getNoDuplicates(fiveCombinations, fourCombinations);
        updatedFive = fiveCombinations;

        double threeCombinationsMultipliers =  getCombinationMultiplier(updatedThree, threeRatio);
        double fourCombinationsMultipliers =  getCombinationMultiplier(updatedFour, fourRatio);
        double fiveCombinationsMultipliers =  getCombinationMultiplier(updatedFive, fiveRatio);

        totalMultiplier = fiveCombinationsMultipliers + fourCombinationsMultipliers + threeCombinationsMultipliers;

        return totalMultiplier;
    }

    @Override
    public List<Symbol> getSymbolList() {
        return symbolList;
    }

    @Override
    public Board getBoard(){
        return board;
    }

    @Override
    public int getFreeSpins(){
        return freeSpins;
    }

}
