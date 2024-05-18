package kolo2;

public abstract class BetterArray implements ArrayOperations{
//    public int getMaximumDepth() {
//        return MINIMUM_LENGTH;
//    }

    @Override
    public double getTemperature() {
        return ArrayOperations.super.getTemperature() + 5;
    }
}
