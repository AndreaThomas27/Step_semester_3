
public class EmployeeCompanyInfo {

    static class Employee {

        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees created: " + employeeCount);
        }
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee("Ravi", 45000);
        Employee emp2 = new Employee("Divya", 55000);
        Employee emp3 = new Employee("Arjun", 40000);

        Employee.printCompanyInfo();
    }
}
