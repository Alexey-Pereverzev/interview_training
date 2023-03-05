package org.example.lesson_01;

import org.example.lesson_01.task1.Person;
import org.example.lesson_01.task3.Circle;
import org.example.lesson_01.task3.Figure;
import org.example.lesson_01.task3.Square;
import org.example.lesson_01.task3.Triangle;

public class Main {
    public static void main(String[] args) {
        Person person = Person.Builder.newBuilder()
                .withFirstName("Peter")
                .withLastName("Jackson")
                .withMiddleName("")
                .withAge(30)
                .withCountry("USA")
                .withGender("Male")
                .withPhone("+1-105-268-31-28")
                .withAddress("620 Atlantic Ave, Brooklyn, NY")
                .build();
        System.out.println(person.toString());
        System.out.println();

        Circle circle = new Circle(8,7,1);
        Square square = new Square(3,3,7,5);
        Triangle triangle = new Triangle(8,2,10,5,12,3);

        circle.describeMe();
        square.describeMe();
        triangle.describeMe();
    }
}
