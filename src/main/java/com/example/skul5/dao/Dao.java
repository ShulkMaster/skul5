package com.example.skul5.dao;
import com.example.skul5.domain.Model;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> readAll() throws DataAccessException;

    @Transactional
    void create(T model) throws DataAccessException;

    T read(Integer id) throws DataAccessException;

    @Transactional
    void update(T model) throws DataAccessException;

    @Transactional
    void delete(Integer id) throws DataAccessException;

}
