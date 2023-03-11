package org.example.lesson_05;

import java.util.ArrayList;

public class FemaleNames {
    private final ArrayList<String> femaleNames = new ArrayList<>(40);

    public String generate() {
        return femaleNames.get((int) Math.floor(Math.random()*femaleNames.size()));
    }

    public FemaleNames() {
        femaleNames.add("Анастасия");
        femaleNames.add("Анна");
        femaleNames.add("Мария");
        femaleNames.add("Елена");
        femaleNames.add("Дарья");
        femaleNames.add("Алина");
        femaleNames.add("Ирина");
        femaleNames.add("Екатерина");
        femaleNames.add("Арина");
        femaleNames.add("Полина");
        femaleNames.add("Ольга");
        femaleNames.add("Юлия");
        femaleNames.add("Татьяна");
        femaleNames.add("Наталья");
        femaleNames.add("Виктория");
        femaleNames.add("Елизавета");
        femaleNames.add("Ксения");
        femaleNames.add("Милана");
        femaleNames.add("Вероника");
        femaleNames.add("Алиса");
        femaleNames.add("Валерия");
        femaleNames.add("Александра");
        femaleNames.add("Ульяна");
        femaleNames.add("Кристина");
        femaleNames.add("София");
        femaleNames.add("Марина");
        femaleNames.add("Светлана");
        femaleNames.add("Варвара");
        femaleNames.add("Софья");
        femaleNames.add("Диана");
        femaleNames.add("Яна");
        femaleNames.add("Кира");
        femaleNames.add("Ангелина");
        femaleNames.add("Маргарита");
        femaleNames.add("Ева");
        femaleNames.add("Алёна");
        femaleNames.add("Дарина");
        femaleNames.add("Карина");
        femaleNames.add("Василиса");
        femaleNames.add("Олеся");
    }


}
