package com.example.skul5.dao;

import com.example.skul5.domain.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDao implements Dao<Student> {

    private static final String getAllQuery = "SELECT * FROM PUBLIC.estudiante";

    @PersistenceContext(unitName = "DBEscuela")
    private final EntityManager em;

    public StudentDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Student> readAll() throws DataAccessException {
        System.out.println("Reading all");
        Query query = em.createNativeQuery(getAllQuery, Student.class);
        return query.getResultList();
    }

    @Override
    public void create(Student student) {
        System.out.println("Bueno llego aqui");
        em.persist(student);
    }

    @Override
    public Student read(Integer id) throws DataAccessException {
        return em.find(Student.class, id);
    }

    @Override
    public void update(Student model) throws DataAccessException {
        em.merge(model);
        em.flush();
    }

    @Override
    public void delete(Integer id) throws DataAccessException {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }

}
