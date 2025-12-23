package io.github.rubenurena.manager.domain.employee;

import io.github.rubenurena.manager.services.EventManager;

public class Employee<T extends EventManager> {
    private final String name;
    private final String lastName;
    private final int ID;
    private static int counter;
    private Profession profession;

    public Employee(String lastName, String name, Profession profession) {
        this.lastName = lastName;
        this.name = name;
        this.profession = profession;
        counter++;
        this.ID = counter;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Profession getProfession() {
        return profession;
    }

    public int getID() {
        return ID;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
