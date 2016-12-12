package com.tiy;

/**
 * Created by erronius on 12/12/2016.
 */
public class ChocolateMaker {

    public static final int BIG_CHOC_VALUE = 5;

    /**
     *
     * @param smallBars - number of small bars to work with
     * @param bigBars - number of big bars to work with
     * @param goal - desired total
     * @return Number of small bars in the "recipe", or -1 if we don't have enough
     */
    public int makeChocolate (int smallBars, int bigBars, int goal) {
        if (goal < 0) {
            return -1;
        }
        if (goal == 0) {
            return 0;
        }
        int chocPackage = 0;
        int numBigBarsDesired = goal / BIG_CHOC_VALUE;
        if (bigBars >= numBigBarsDesired) {
            chocPackage += numBigBarsDesired*BIG_CHOC_VALUE;
        } else if (bigBars > 0){
            chocPackage += bigBars*BIG_CHOC_VALUE;
        }
        long possibleTotal = (long)chocPackage + (long)smallBars;
        if (possibleTotal < goal) {
            return -1;
        }
        return goal - chocPackage;
    }

    public int makeChocolateWithLoop (int smallBars, int bigBars, int goal) {
        if (goal < 0) {
            return -1;
        }
        if (goal == 0) {
            return 0;
        }
        int chocPackage = 0;
        //while (chocPackage <= (goal + BIG_CHOC_VALUE) && bigBars > 0) { //Why the heck does this fail
        while ((chocPackage + BIG_CHOC_VALUE <= goal) && bigBars > 0) {
            chocPackage += BIG_CHOC_VALUE;
            bigBars--;
        }
        if (chocPackage + smallBars < goal) {
            return -1;
        }
        return goal - chocPackage;
    }
}
