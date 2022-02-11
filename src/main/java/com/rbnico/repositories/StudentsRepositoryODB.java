package com.rbnico.repositories;

import com.rbnico.JPAUtility;
import com.rbnico.models.Student;
import com.rbnico.models.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentsRepositoryODB implements Repository<Student, Integer>{
    EntityManager em = JPAUtility.getEntityManager();

    @Override
    public boolean create(Student entity) {
        em = JPAUtility.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Student find(Integer id) {
        em = JPAUtility.getEntityManager();
        try {
            return em.find(Student.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Student> findAll() {
        em = JPAUtility.getEntityManager();
        TypedQuery<Student> students= em.createQuery("SELECT s FROM Student s", Student.class);
        return students.getResultList();
    }

    @Override
    public boolean update(Student newEntity) {
        em = JPAUtility.getEntityManager();
        try {
            Student oldStudent = find(newEntity.getId());
            em.getTransaction().begin();
            oldStudent.setName(newEntity.getName());
            oldStudent.setLastname(newEntity.getLastname());
            oldStudent.setAge(newEntity.getAge());
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            em = JPAUtility.getEntityManager();
            Query query = em.createQuery("DELETE FROM Student s WHERE s.id = ?1");
            query.setParameter(1, id);
            em.getTransaction().begin();
            query.executeUpdate();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Student> findBy(Object i, Object o) {
        try {
            em = JPAUtility.getEntityManager();
            Query query = em.createQuery("SELECT s FROM Student s WHERE s.age >= ?1 and s.age <= ?2", Student.class);
            query.setParameter(1, (Integer)i);
            query.setParameter(2, (Integer)o);
            em.getTransaction().begin();
            List<Student> students = query.getResultList();
            em.getTransaction().commit();
            return students;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
