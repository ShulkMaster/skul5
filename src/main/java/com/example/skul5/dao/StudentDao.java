package com.example.skul5.dao;

import com.example.skul5.domain.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDao implements Dao {

    private static final String getAllQuery = "SELECT * FROM PUBLIC.STUDENT";

    @PersistenceContext(unitName = "skul5")
    private EntityManager em;

    @Override
    public List<Student> findAll() throws DataAccessException {
        Query query = em.createNativeQuery(getAllQuery, Student.class);
        return query.getResultList();
    }

    @Override
    public Student findOne(Integer id) throws DataAccessException {
        return em.find(Student.class, id);
    }
}
