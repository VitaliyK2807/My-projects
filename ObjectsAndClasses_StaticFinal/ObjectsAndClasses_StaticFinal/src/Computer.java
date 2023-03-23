public class Computer {
    public CPU cpu;
    public RAM ram;
    public Memory memory;
    public Screen screen;
    public Keyboard keyboard;
    public double totalWeight;
    private final String vendor;
    private final String name;



    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }
    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }
    public void setCpu (CPU cpu) {
        this.cpu = cpu;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double TotalWeight () {
        return totalWeight = (ram.getRamWeight() + cpu.getCpuWeight() +
                screen.getScreenWeight() + memory.getMemoryWeight() + keyboard.getKeyboardWeight());
    }

    public String toString () {
        return "Производитель компьютера: " + getVendor() + "\n" +
                "Название компьютера: " + getName() + "\n" +
                "Общий вес: " + TotalWeight() + " гр." + "\n" +
                "" + "\n" +
                "Состав компьютера:" + "\n" +
                "Память: " + "\n" +
                "   - Частота: " + cpu.getCpuFrequency() + " ГГц" + "\n" +
                "   - Количество ядер: " + cpu.getCpuCountCores() + "\n" +
                "   - Производитель: " + cpu.getCpuManufacturer() + "\n" +
                "   - Вес: " + cpu.getCpuWeight() + " гр." + "\n" +
                "Оперативная память: " + "\n" +
                "   - Тип: " + ram.getRamType() + "\n" +
                "   - Объём памяти: " + ram.getRamVolume() + " Гб" + "\n" +
                "   - Вес: " + ram.getRamWeight() + " гр." + "\n" +
                "Накопитель информации: " + "\n" +
                "   - Тип: " + memory.getMemoryType() + "\n" +
                "   - Объём памяти: " + memory.getMemoryVolume() + (" Гб") + "\n" +
                "   - Вес: " + memory.getMemoryWeight() + " гр." + "\n" +
                "Экран: " + "\n" +
                "   - Диагональ: " + screen.getDiagonal() + "'" + "\n" +
                "   - Тип: " + screen.getScreenType() + "\n" +
                "   - Вес: " + screen.getScreenWeight() + " гр." + "\n" +
                "Клавиатура: " + "\n" +
                "   - Тип: " + keyboard.getKeyboardType() + "\n" +
                "   - Наличие подсветки: " + (keyboard.getBacklight() ? "Есть" : "Нет") + "\n" +
                "   - Вес: " + keyboard.getKeyboardWeight() + " гр." + "\n";
    }


}
