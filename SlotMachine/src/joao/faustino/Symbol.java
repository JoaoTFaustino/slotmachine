package joao.faustino;

public class Symbol{
    private String name;
    private double points;
    private boolean isWild;
    private boolean isBonus;
    private int probability;

    /**
     * Creates a Symbol that as a name (tag) and points
     */
    Symbol(String tag, double points, int probability){
        this.name = tag;
        this.points = points;
        isBonus = false;
        isWild = false;
        this.probability = probability;
    }

    /**
     * If tag == wild
     * Or tag == bonus
     * Update the fields;
     */
    Symbol(String tag, int probability){
        String aux = tag.toLowerCase();
        switch (aux){
            case "wild":
                this.name = "Wild";
                this.points = 1;
                isBonus = false;
                isWild = true;
                this.probability = probability;
                break;
            case "bonus":
                this.name = "Bonus";
                this.points = 1;
                isBonus = true;
                isWild = false;
                this.probability = probability;
                break;
            default:
                new Symbol(tag,0,0);
                break;
        }
    }

    /**
     * Returns the Symbol's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Symbol's points
     */
    public double getPoints() {
        return points;
    }

    /**
     * Compares two Symbols
     */
    public boolean compareTo(Symbol symbol){
        if ((getName().compareTo(symbol.getName()) == 0) && (getPoints() == symbol.getPoints())) {
            return true;
        }
        return false;
    }

    /**
     * Compares two Symbols if a Symbol is Wild return true
     */
    public boolean compareMultiplier(Symbol symbol){
        if (isSymbolWild() && !symbol.isSymbolBonus() || (symbol.isSymbolWild()) || compareTo(symbol)) {
            return true;
        }
        return false;
    }

    /**
     * Returns the Symbol's isWild field
     */
    public boolean isSymbolWild(){
        return isWild;
    }

    /**
     * Returns the Symbol's isBonus field
     */
    public boolean isSymbolBonus(){
        return isBonus;
    }

    public int getProbability(){
        return probability;
    }

    public void setBonusPoints(double points){
        this.points += points;
    }


}
