package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        int countManager = 80;
        int countTopManager = 10;
        int countOperator = 180;
        int percent = 50;
        Company company = new Company(10_000_001);
        CompaniesAdd(company, countManager, countTopManager, countOperator);
        outputSorted(company, 15, 30);
        deleteEmploes(company, percent);
        outputSorted(company, 10, 30);
    }

    public static void CompaniesAdd (Company company, int countManager,
                                  int countTopManager, int countOperator) {

        Manager manager = new Manager(generateSalary (60_000, 70_000));
        List<Employee> listManager = new ArrayList<>();
        for (int i = 0; i < countManager; i++) {
            listManager.add(manager);
        }
        company.hireAll(listManager);

        List<Employee> listTopManager = new ArrayList<>();

        TopManager topManager = new TopManager(generateSalary (70_000, 100_000),
                (int) company.getIncome());
        for (int i = 0; i < countTopManager; i++) {
            listTopManager.add(topManager);
        }
        company.hireAll(listTopManager);

        List<Employee> listOperator = new ArrayList<>();
        Operator operator = new Operator(generateSalary (50_000, 100_000));
        for (int i = 0; i < countOperator; i++) {
            listOperator.add(operator);
        }
        company.hireAll(listOperator);

    }
    public static void deleteEmploes (Company company, int percent) {
        Random random = new Random();
        int count = company.getCompany().size() * percent / 100;
        int length;
        for (int i = 0; i < count; i++) {
            length = random.nextInt(company.getCompany().size());
            company.fire(company.getCompany().get(length));
        }
    }

    public static void outputSorted(Company company, int sortedOne, int sortedTwo) {
        int i = 0;
        System.out.println("Список из " + sortedOne + " зарплат по убыванию");
        for (Employee emploee:
                company.getTopSalaryStaff(sortedOne)) {
            System.out.println(++i + " " + emploee.getMonthSalary() + " руб.");
        }
        i = 0;
        System.out.println("Список из " + sortedTwo + " зарплат по возрастанию");
        for (Employee emploee:
                company.getLowestSalaryStaff(sortedTwo)) {
            System.out.println(++i + " " + emploee.getMonthSalary() + " руб.");
        }
    }

    public static int generateSalary (int from, int to) {
        Random random = new Random();
        return random.nextInt(from, to);
    }
}
