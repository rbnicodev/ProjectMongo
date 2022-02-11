package com.rbnico.repositories;

import com.rbnico.models.Teacher;
import org.bson.Document;
import com.rbnico.JPAUtility;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


public class TeachersRepositoryODB implements Repository<Teacher, Integer>{
    EntityManager em = JPAUtility.getEntityManager();
    @Override
    public boolean create(Teacher entity) {
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
    public Teacher find(Integer id) {
        em = JPAUtility.getEntityManager();
        try {
            return em.find(Teacher.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Teacher> findAll() {
        em = JPAUtility.getEntityManager();
        TypedQuery<Teacher> teachers= em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return teachers.getResultList();
    }

    @Override
    public boolean update(Teacher newEntity) {
        em = JPAUtility.getEntityManager();
        try {
            Teacher oldTeacher = find(newEntity.getId());
            em.getTransaction().begin();
            oldTeacher.setName(newEntity.getName());
            oldTeacher.setLastname(newEntity.getLastname());
            oldTeacher.setSegSocial(newEntity.getSegSocial());
            oldTeacher.setSalary(newEntity.getSalary());
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
            Query query = em.createQuery("DELETE FROM Teacher t WHERE t.id = ?1");
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
    public List<Teacher> findBy(Object i, Object o) {
        try {
            em = JPAUtility.getEntityManager();
            Query query = em.createQuery("SELECT t FROM Teacher t WHERE t.salary >= ?1 and t.salary <= ?2", Teacher.class);
            query.setParameter(1, (Integer)i);
            query.setParameter(2, (Integer)o);
            em.getTransaction().begin();
            List<Teacher> teachers = query.getResultList();
            em.getTransaction().commit();
            return teachers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
