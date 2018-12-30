package ru.job4j.Professions;

public class Engineer extends Profession {

    public House build(){
        House house = new House( 10, 15, 2, 6);
        return house;
    }
}