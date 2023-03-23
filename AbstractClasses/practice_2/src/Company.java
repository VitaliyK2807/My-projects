package src;

import java.util.*;

public class Company implements Employee{

    public List<Employee> company = new ArrayList<>();

    public int companyIncome;

    public Company(int companyIncome) {
        this.companyIncome = companyIncome;
    }

    public void hire(Employee employee) {
        company.add(employee);
    }

    public void hireAll(Collection<Employee> employes) {
        company.addAll(employes);
    }

    public void fire(Employee employee) {
        company.remove(employee);
    }

    public double getIncome() {
      return companyIncome;
    }
    public List<Employee> getLowestSalaryStaff(int count){
        List<Employee> list = new ArrayList<>();
        MyLowestComparator myLowestComparator = new MyLowestComparator();

        list.addAll(company);
        list.sort(myLowestComparator);

        if (list.size() >= count) {
            return list.subList(0, count);
        } else {
            return list;
        }
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> list = new ArrayList<>();
        MyTopComparator myComparator = new MyTopComparator();

        list.addAll(company);
        list.sort(myComparator);

        if (list.size() >= count) {
           return list.subList(0, count);
        } else {
            return list;
        }
    }

    public List<Employee> getCompany() {
        List<Employee> list = new ArrayList<>();
        list.addAll(company);
        return list;
    }


    public class MyTopComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            if (employee2.getMonthSalary() == employee1.getMonthSalary()) {
                return 0;
            } else if (employee2.getMonthSalary() > employee1.getMonthSalary()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public class MyLowestComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            if (employee1.getMonthSalary() == employee1.getMonthSalary()) {
                return 0;
            } else if (employee1.getMonthSalary() > employee2.getMonthSalary()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    @Override
    public int getMonthSalary() {

        return 0;
    }

}
