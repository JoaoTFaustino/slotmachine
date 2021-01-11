package joao.faustino;

import java.util.List;

public class SymbolGenerator extends RandomGenerator{
    private List<Symbol> symbolList;

    /**
     * Creates a symbolGenerator with the given List of Symbols
     */
    SymbolGenerator(List<Symbol> symbolList){
        super(symbolList.size());
        this.symbolList = symbolList;
    }

    /**
     * Returns a random Symbol from the List
     * Probability doesn't matter
     */
    Symbol getRandom(){
        return symbolList.get(super.getRandomNumber());
    }
}
