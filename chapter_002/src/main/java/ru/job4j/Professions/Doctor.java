package ru.job4j.Professions;

public class Doctor extends Profession {
    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose(patient.getName(), "Prostuda");
        return diagnose;
    }
}