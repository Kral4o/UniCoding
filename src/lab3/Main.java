package lab3;

interface Payable{
    abstract void GetPaid(int wage);
}

abstract class Employee implements Payable{
    public String Name;
    int salary;
    void GetSalary(){
        System.out.println(this.salary);
    }
    abstract void Work();
}

class Developer extends Employee{
    public String Name;
    int salary;

    @Override
    void Work() {
        System.out.println("I am working on this code.");

    }

    @Override
    public void GetPaid(int wage) {
        this.salary += wage;
    }
}

class HR extends Employee{
    String Name;
    int salary;

    @Override
    void Work() {
        System.out.println("I am firing people for a living.");

    }

    @Override
    public void GetPaid(int wage) {
        this.salary += wage;
    }
}

class Office{
    String companyName;
    int employeeCount = 2;

    void companyStats(Employee[] employees){
        System.out.println("The" + companyName + "company has" + employeeCount + "Employees: ");

        for (Employee employee : employees)
        {
            System.out.println(employee.Name);
            employee.GetSalary();
        }
    }

}

class Main{
    public static void main(String[] args){
        Office Asus = new Office();
        Asus.companyName = "Asus";

        Developer dev1 = new Developer();
        dev1.Name = "Nikola";
        dev1.salary = 1500;

        dev1.Work();

        HR hr1 = new HR();
        hr1.Name = "Mitko";
        hr1.salary = 1000;

        hr1.Work();

        Employee[] workers = {dev1 , hr1};

        Asus.companyStats(workers);




    }
}