package io.github.rubenurena.manager.domain.company;

import io.github.rubenurena.manager.domain.employee.Employee;
import io.github.rubenurena.manager.services.EventManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Department <T extends  EventManager>{
    public T eventManager;
    public int employeeMax;
    public  Set<Employee<T>> employees;
    public final int id;
    public static int count;

    public Department(int employeeMax,ArrayList<Employee<T>> employees, T eventManager) {
        this.employees = new HashSet<>();
        addEmployee(employees);
        this.employeeMax = employeeMax;
        this.eventManager = eventManager;
        count++;
        this.id = count;
    }

    public void addEmployee(Employee<T> employee){
        if (this.employees.size() < this.employeeMax){
            this.employees.add(employee);
        }
    }
    public void addEmployee(ArrayList<Employee<T>> employees){
        for (var a : employees){
            if (this.employees.size() < this.employeeMax){
                this.employees.add(employees.getFirst());
                employees.removeFirst();
            }else {
                return;
            }
        }
    }
    public void removeEmployee(Employee<T> employee){
        this.employees.remove(employee);
    }
    public void removeEmployee(ArrayList<Employee<T>> employees){
        employees.forEach(this.employees::remove);
    }

    public Set<Employee<T>> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee<T>> employees) {
        if(employees.size() <= this.employeeMax){
            this.employees = employees;
        }

    }

    public int getEmployeeMax() {
        return employeeMax;

    }

    public void setEmployeeMax(int employeeMax) {
        this.employeeMax = employeeMax;

    }






}
