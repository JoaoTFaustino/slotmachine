package joao.faustino;

import java.util.List;

public class BoardGenerator extends Board{
    private SymbolGenerator symbolGenerator;

    /**
     * Creates a boardGenerator, with a given rows and columns
     * and a List of the Symbols
     */
    BoardGenerator(int rows, int columns, List<Symbol> symbolList){
        super(rows, columns);
        symbolGenerator = new SymbolGenerator(symbolList);
    }

    /**
     * Generates a random board
     */
    void generatorStart(){
        for(int i = 0; i < super.getBoardRows(); i++){
            for(int j = 0; j < super.getBoardColumns(); j++){
                super.setBoard(symbolGenerator.getRandom(), i, j);
            }
        }
    }

}
