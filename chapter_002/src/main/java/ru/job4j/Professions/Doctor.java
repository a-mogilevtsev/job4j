package ru.job4j.Professions;

public class Doctor extends Profession {
    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }
}