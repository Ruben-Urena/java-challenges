package io.github.rubenurena.manager.domain.company;
import io.github.rubenurena.manager.services.EventManager;

import java.util.ArrayList;
import java.util.Set;

public class Company <T extends  EventManager>{
    T eventManager;
    private final Set<Department<T>> departments;
    private int departmentsMax;


    public Company(Set<Department<T>> departments, int departmentCap) {
        this.departments = departments;
        this.departmentsMax = departmentCap;

    }

    public Set<Department<T>> getDepartments() {
        return departments;
    }

    public void removeDepartment(Department<T> department){
        this.departments.remove(department);
    }

    public void removeDepartments(ArrayList<Department<T>> departmentsToRemove){
        departmentsToRemove.forEach(this.departments::remove);
    }

    public void addDepartments(ArrayList<Department<T>> departmentsToAdd){
        for (var a : departmentsToAdd){
            if(this.departments.size() < this.departmentsMax){
                this.departments.add(departmentsToAdd.getFirst());
                departmentsToAdd.removeFirst();
            }else {
                return;
            }
        }
    }

    public int getDepartmentsMax() {
        return departmentsMax;
    }

    public void setDepartmentsMax(int departmentsMax) {
        this.departmentsMax = departmentsMax;
    }
}
