package src;

public class TopManager implements Employee {

    private static final double COMPANY_INCOME = 10_000_000;
    private int sum;
    private int fixedSalary;

    public TopManager(int fixedSalary, int sum) {
        this.fixedSalary = fixedSalary;
        this.sum = sum;
    }

    @Override
    public int getMonthSalary() {
        int salary = (int) (fixedSalary + fixedSalary * 1.5);
        return  sum > COMPANY_INCOME ? salary : fixedSalary;
    }

}
