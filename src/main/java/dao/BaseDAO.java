package dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mykola- on 21.12.2015.
 */
public interface BaseDAO<T> {

    void create(T object) throws SQLException;

    T findById (String id) throws SQLException;

    void update(T object) throws SQLException;

    void delete(T object) throws SQLException;

    List<T> getAll() throws SQLException;
}
