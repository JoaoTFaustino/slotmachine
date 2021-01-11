package joao.faustino;

import java.util.ArrayList;
import java.util.List;

public class Combinations{
    private Symbol symbol;
    private List<Matrix> combination = new ArrayList<>();

    Combinations(Symbol symbol, Matrix... matrix){
        for(Matrix aux: matrix){
            combination.add(aux);
        }
        this.symbol = symbol;
    }

    void append(Matrix matrix){
        combination.add(matrix);
    }

    String fullCombination(){
        StringBuilder builder = new StringBuilder();
        builder.append("Combination of " + symbol.getName() + ": ");
        for(Matrix matrix : combination){
            builder.append(matrix.printMatrix()+" + ");
        }
        builder.deleteCharAt(builder.length()-2);
        return builder.toString();
    }

    List<Matrix> getMatrix(){
        return combination;
    }

    boolean compareCombinations(Combinations combination){
        int lowSize = combination.getMatrix().size();
        if(lowSize > getMatrix().size()){
            lowSize = getMatrix().size();
        }
        for(int i = 0; i < lowSize; i++){
            if(!(getMatrix().get(i).printMatrix().equals(combination.getMatrix().get(i).printMatrix()))){
                return false;
            }
        }
        return true;
    }

    Symbol getSymbol(){
        return symbol;
    }


}
