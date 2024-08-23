package BaiTap_Java_19_08_2024.Bai2;

import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    protected String employeeId;
    protected String name;
    protected double salary;

    public Employee(String employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary();
    }
}
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String employeeId, String name, double salary, double bonus) {
        super(employeeId, name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }
}
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String employeeId, String name, double salary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, salary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
class ContractEmployee extends Employee {
    private double contractAmount;

    public ContractEmployee(String employeeId, String name, double salary, double contractAmount) {
        super(employeeId, name, salary);
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculateSalary() {
        return contractAmount;
    }
}

class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(String employeeId) throws EmployeeNotFoundException {
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            employees.remove(employee);
        } else {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
        }
    }

    public Employee findEmployeeById(String employeeId) throws EmployeeNotFoundException {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }

    public void listAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

        // Thêm nhân viên
        employeeManager.addEmployee(new FullTimeEmployee("FT001", "John Doe", 5000, 1000));
        employeeManager.addEmployee(new PartTimeEmployee("PT001", "Jane Smith", 0, 20, 15));
        employeeManager.addEmployee(new ContractEmployee("CT001", "Bob Johnson", 0, 3000));

        // Hiển thị danh sách nhân viên
        System.out.println("All Employees:");
        employeeManager.listAllEmployees();

        // Tính tổng lương
        System.out.println("Total Salary: " + employeeManager.calculateTotalSalary());

        // Tìm kiếm nhân viên
        try {
            Employee employee = employeeManager.findEmployeeById("FT001");
            System.out.println("Found Employee: " + employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Xóa nhân viên
        try {
            employeeManager.removeEmployee("PT001");
            System.out.println("Employee PT001 removed.");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Hiển thị danh sách nhân viên sau khi xóa
        System.out.println("All Employees after removal:");
        employeeManager.listAllEmployees();
    }
}
