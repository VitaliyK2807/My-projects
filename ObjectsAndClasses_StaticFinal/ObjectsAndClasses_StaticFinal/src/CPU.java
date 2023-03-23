public class CPU {
    private final double cpuFrequency;
    private final int cpuCountCores;
    private final String cpuManufacturer;
    private final double cpuWeight;

    public double getCpuFrequency() {
        return cpuFrequency;
    }

    public int getCpuCountCores() {
        return cpuCountCores;
    }

    public String getCpuManufacturer() {
        return cpuManufacturer;
    }

    public double getCpuWeight() {
        return cpuWeight;
    }

    public CPU(double cpuFrequency, int cpuCountCores, String cpuManufacturer, double cpuWeight) {
        this.cpuFrequency = cpuFrequency;
        this.cpuCountCores = cpuCountCores;
        this.cpuManufacturer = cpuManufacturer;
        this.cpuWeight = cpuWeight;
    }


}
