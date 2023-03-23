package src;

import java.util.Random;

public class Manager implements Employee {

    private int fixedSalary;
    public Manager(int fixedSalary) {
        this.fixedSalary = fixedSalary;

    }

    @Override
    public int getMonthSalary() {
        return (int) (generateProfit() * 0.05 + fixedSalary);
    }
    public int generateProfit () {
        int minProfit = 115_000;
        int maxProfit = 140_000;

        Random random = new Random();

        return  random.nextInt(minProfit, maxProfit);
    }

}
