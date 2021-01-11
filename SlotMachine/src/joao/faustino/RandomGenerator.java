package joao.faustino;

import java.util.Random;

public class RandomGenerator {
    private final int range;
    private Random random = new Random();

    /**
     * Creates a randomGenerator seed with the range given
     * (0 - range)
     */
    RandomGenerator(int range){
        this.range = range;
    }

    /**
     * Returns a random number between 0 and range
     */
    int getRandomNumber(){
        return random.nextInt(range);
    }
}
