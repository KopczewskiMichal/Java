package kolo2;

public interface ArrayOperations {
    public static final int MINIMUM_LENGTH=3;
    public int getMaximumDepth();
    public default double getTemperature() {
        return 10.0;
    }
    public default int getMaximumLength() {
        return MINIMUM_LENGTH;
    }

}
