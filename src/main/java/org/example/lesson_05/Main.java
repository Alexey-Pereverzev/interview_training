package org.example.lesson_05;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {


    public static void main(String[] args) {

        SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        StudentDao dao = new StudentDao(sFactory);
        dao.initDB();

    }




}
