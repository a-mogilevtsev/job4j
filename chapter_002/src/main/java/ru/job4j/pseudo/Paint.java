package ru.job4j.pseudo;

/**
 * Created by a.mogilevtsev on 1/8/2019.
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Shape tr = new Triangle();
        Shape sq = new Square();

    }
}
