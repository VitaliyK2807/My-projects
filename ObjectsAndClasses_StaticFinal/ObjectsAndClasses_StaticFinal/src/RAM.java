public class RAM {
    private final String ramType;
    private final int ramVolume;
    private final double ramWeight;

    public RAM(String ramType, int ramVolume, double ramWeight) {
        this.ramType = ramType;
        this.ramVolume = ramVolume;
        this.ramWeight = ramWeight;
    }

    public String getRamType() {
        return ramType;
    }

    public int getRamVolume() {
        return ramVolume;
    }

    public double getRamWeight() {
        return ramWeight;
    }
}
