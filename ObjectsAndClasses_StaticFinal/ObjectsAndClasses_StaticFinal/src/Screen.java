public class Screen {
    private final int diagonal;
    private final ScreenType screenType;
    private final double screenWeight;

    public Screen(int diagonal, ScreenType screenType, double screenWeight) {
        this.diagonal = diagonal;
        this.screenType = screenType;
        this.screenWeight = screenWeight;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public double getScreenWeight() {
        return screenWeight;
    }
}
