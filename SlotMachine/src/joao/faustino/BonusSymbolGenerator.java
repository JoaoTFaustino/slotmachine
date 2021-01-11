package joao.faustino;

import java.util.ArrayList;
import java.util.List;

public class BonusSymbolGenerator{
    private List<Symbol> symbolListUpdated = new ArrayList<>();
    private SymbolGenerator symbolGenerator;

    /**
     * Creates a symbolGenerator with the given List of Symbols
     */
    BonusSymbolGenerator(List<Symbol> symbolList){
        for(Symbol symbol : symbolList) {
            addToListXTimes(symbol.getProbability(),symbol);
        }

        symbolGenerator = new SymbolGenerator(symbolListUpdated);
    }

    private void addToListXTimes(int number, Symbol symbol){
        for(int i = 0; i < number; i++){
            symbolListUpdated.add(symbol);
        }
    }

    /**
     * Returns a random Symbol from the List
     */
    Symbol getRandom(){
        return symbolListUpdated.get(symbolGenerator.getRandomNumber());
    }

}
