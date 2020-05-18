package com.example.skul5.dao;

import com.example.skul5.domain.Student;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface Dao {

    List<Student> findAll() throws DataAccessException;

    Student findOne(Integer id) throws DataAccessException;

}
