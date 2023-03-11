package org.example.lesson_05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class StudentDao {

    private final SessionFactory sf;

    private static final Names names = new Names();
    private static final Surnames surnames = new Surnames();
    private static final FemaleNames femaleNames = new FemaleNames();
    private static final FemaleSurnames femaleSurnames = new FemaleSurnames();

    public StudentDao(SessionFactory sFactory) {
        this.sf = sFactory;
    }

    public void initDB() {
        EntityManager em = sf.openSession();
        em.getTransaction().begin();
        double mark;
        for (int i = 0; i < 1000; i++) {
            mark = (Math.floor(Math.random()*200))/100+3;
            Student student = new Student(generatedStudent(), mark);
            em.persist(student);
        }
        em.getTransaction().commit();
        em.close();
    }


//    public void persist(Student entity) {
//        getCurrentSession().save(entity);
//    }
//
//    public void update(Student entity) {
//        getCurrentSession().update(entity);
//    }
//
//    public Student findById(String id) {
//        return (Student) getCurrentSession().get(Student.class, id);
//    }
//    public void delete(Student entity) {
//        getCurrentSession().delete(entity);
//    }
//    @SuppressWarnings("unchecked")
//    public List<Student> findAll() {
//        return (List<Student>) getCurrentSession().createQuery("from Student").list();
//    }
//
//    public void deleteAll() {
//        List<Student> entityList = findAll();
//        for (Student entity : entityList) {
//            delete(entity);
//        }
//    }
//
    private static String generatedStudent() {
        if (Math.random()<0.5) {
            return names.generate() + " " + surnames.generate();
        } else {
            return femaleNames.generate() + " " + femaleSurnames.generate();
        }
    }



}
