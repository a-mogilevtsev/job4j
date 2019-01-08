package ru.job4j.pseudo;

/**
 * Created by a.mogilevtsev on 1/8/2019.
 */
public class Triangle implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +  ");
        pic.append(" + + ");
        pic.append("+   +");
        pic.append("+++++");
        return pic.toString();
    }
}
