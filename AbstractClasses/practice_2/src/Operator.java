package src;

public class Operator implements Employee {

    private int fixedSalary;

    public Operator(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public int getMonthSalary() {
        return fixedSalary;
    }
}
