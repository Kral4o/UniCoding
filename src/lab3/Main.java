package lab3;

interface Payable {
    void getPaid(int wage);
}

abstract class Employee implements Payable{
    protected String name;
    protected int salary;

    protected Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void getPaid(int wage) {
        if (wage > 0) {
            this.salary += wage;
        }
    }

    abstract void work();
}

class Developer extends Employee {
    Developer(String name, int salary) {
        super(name, salary);
    }
    
    @Override
    void work() {
        System.out.println(
        name 
        + " is working on this code.");
    }
}

class HR extends Employee {
    HR(String name, int salary) {
        super(name, salary);
    }

    @Override
    void work() {
        System.out.println(
        name
        + " is working on employee"
        + " documentation.");
    }
}

class Office {
    private final String companyName;

    Office(String companyName) {
        this.companyName = companyName;
    }

    void printCompanyStats(Employee[] employees) {
        System.out.println(
        "The " + companyName + " company has "
        + employees.length + " employees:");

        for(Employee employee : employees) {
            System.out.println(
            "- " + employee.getName() 
            + " | Salary: " + employee.getSalary());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Office asus = new Office("Asus");

        Developer dev1 = new Developer("Nikola", 1500);
        HR hr1 = new HR("Mitko", 1000);

        dev1.work();
        hr1.work();

        dev1.getPaid(500);
        hr1.getPaid(500);

        Employee[] workers = { dev1 , hr1};

        asus.printCompanyStats(workers);

    }
}