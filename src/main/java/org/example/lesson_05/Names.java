package org.example.lesson_05;

import java.util.ArrayList;

public class Names {
    private final ArrayList<String> names = new ArrayList<>(40);

    public String generate() {
        return names.get((int) Math.floor(Math.random()* names.size()));
    }

    public Names() {
        names.add("Александр");
        names.add("Дмитрий");
        names.add("Максим");
        names.add("Сергей");
        names.add("Андрей");
        names.add("Алексей");
        names.add("Артём");
        names.add("Илья");
        names.add("Кирилл");
        names.add("Михаил");
        names.add("Никита");
        names.add("Матвей");
        names.add("Роман");
        names.add("Егор");
        names.add("Арсений");
        names.add("Иван");
        names.add("Денис");
        names.add("Евгений");
        names.add("Даниил");
        names.add("Тимофей");
        names.add("Владислав");
        names.add("Игорь");
        names.add("Владимир");
        names.add("Павел");
        names.add("Руслан");
        names.add("Марк");
        names.add("Константин");
        names.add("Тимур");
        names.add("Олег");
        names.add("Ярослав");
        names.add("Антон");
        names.add("Николай");
        names.add("Глеб");
        names.add("Данил");
        names.add("Савелий");
        names.add("Вадим");
        names.add("Степан");
        names.add("Юрий");
        names.add("Богдан");
        names.add("Артур");
    }


}
