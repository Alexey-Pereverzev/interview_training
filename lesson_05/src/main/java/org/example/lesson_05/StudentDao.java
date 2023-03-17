package org.example.lesson_05;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class StudentDao {

    private final SessionFactory sf;

    private static final Names names = new Names();
    private static final Surnames surnames = new Surnames();
    private static final FemaleNames femaleNames = new FemaleNames();
    private static final FemaleSurnames femaleSurnames = new FemaleSurnames();

    public StudentDao() {
        this.sf = getSessionFactory();
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    private static String generatedStudent() {
        if (Math.random()<0.5) {
            return names.generate() + " " + surnames.generate();
        } else {
            return femaleNames.generate() + " " + femaleSurnames.generate();
        }
    }

    public void initDB() {
        EntityManager em = sf.openSession();
        em.getTransaction().begin();
        double mark;
        for (int i = 0; i < 1000; i++) {
            mark = ((double)Math.round(Math.random()*200))/100+3;
            Student student = new Student(generatedStudent(), mark);
            em.persist(student);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Optional<Student> findById(long id) {
        EntityManager em = sf.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        if (student!=null) {
            return Optional.of(student);
        } else {
            return Optional.empty();
        }
    }

//    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        EntityManager em = sf.createEntityManager();
        List<Student> students = em.createQuery("from Student", Student.class).getResultList();
        em.close();
        return students;
    }

    public Optional<Student> save(Student student) {
        EntityManager em = sf.createEntityManager();
        Optional<Student> searched = findById(student.getId());
        if (searched.isEmpty()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            em.close();
            return Optional.of(student);
        } else {
            System.out.println("Такой id уже есть в базе");
            return Optional.empty();
        }
    }

    public Student update(Student student) {
        EntityManager em = sf.createEntityManager();
        List searched = em.createQuery("select id from Student s where s.name = :name")
                .setParameter("name", student.getName()).getResultList();
        em.getTransaction().begin();
        if (searched.size()>0) {
            long id = (long) searched.get(0);
            em.find(Student.class, id).setMark(student.getMark());
        }
        em.getTransaction().commit();

        em.close();
        return student;
    }

    public void update(long id, double mark) {
        EntityManager em = sf.createEntityManager();
        em.getTransaction().begin();
        em.find(Student.class, id).setMark(mark);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(long id) {
        EntityManager em = sf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student!=null) em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

}
