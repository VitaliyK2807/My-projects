public class Keyboard {
    private final String keyboardType;
    private final boolean backlight;
    private final double keyboardWeight;

    public Keyboard(String keyboardType, boolean backlight, double keyboardWeight) {
        this.keyboardType = keyboardType;
        this.backlight = backlight;
        this.keyboardWeight = keyboardWeight;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public boolean getBacklight() {
        return backlight;
    }

    public double getKeyboardWeight() {
        return keyboardWeight;
    }
}
