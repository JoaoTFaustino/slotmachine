package joao.faustino;

import java.util.List;

public class BonusBoardGenerator extends Board{
    private BonusSymbolGenerator bonusSymbolGenerator;

    /**
     * Creates a boardGenerator, with a given rows and columns
     * and a List of the Symbols
     */
    BonusBoardGenerator(int rows, int columns, List<Symbol> symbolList){
        super(rows, columns);
        bonusSymbolGenerator = new BonusSymbolGenerator(symbolList);
    }

    /**
     * Generates a random board
     */
    void generatorStart(){
        for(int i = 0; i < super.getBoardRows(); i++){
            for(int j = 0; j < super.getBoardColumns(); j++){
                super.setBoard(bonusSymbolGenerator.getRandom(), i, j);
            }
        }
    }
}
