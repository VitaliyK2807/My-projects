public class Main {
    public static void main(String[] args) {
        CPU intelCore = new CPU(1.1, 5, "Intel", 0.5);
        RAM kingston = new RAM("DD3", 8, 0.7);
        Memory seagate = new Memory(MemoryType.HDD, 1200, 202.0);
        Screen samsung = new Screen(21, ScreenType.TN, 1000.0);
        Keyboard genius = new Keyboard("Мембранная (плёночная)", false, 500.0);
        Computer computerVasya = new Computer("Вася", "Компьютер Васи");
        computerVasya.setCpu(intelCore);
        computerVasya.setRam(kingston);
        computerVasya.setMemory(seagate);
        computerVasya.setScreen(samsung);
        computerVasya.setKeyboard(genius);
        System.out.println(computerVasya);

        RAM crucial = new RAM("DD5", 16, 0.9);
        Screen lg = new Screen(23, ScreenType.IPS, 1100.0);
        Keyboard defender = new Keyboard("Оптическая (фотоэлектрическая) клавиатура",
                true, 350.0);
        Computer desktopComputer = new Computer("ASUS", "Настольный компьютер");
        desktopComputer.setCpu(intelCore);
        desktopComputer.setRam(crucial);
        desktopComputer.setMemory(seagate);
        desktopComputer.setScreen(lg);
        desktopComputer.setKeyboard(defender);
        System.out.println(desktopComputer);

    }
}
