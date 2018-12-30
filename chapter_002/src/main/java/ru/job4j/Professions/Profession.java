package ru.job4j.Professions;
import java.lang.String;

public class Profession {
    String name;
    String type;

    public Profession() {

    }

    public Profession(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}