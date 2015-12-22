package dao;

import model.Specialization;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mykola- on 21.12.2015.
 */
public interface specializationDAO extends BaseDAO<Specialization>{

    List<Specialization> getSpecializationById(String specializationId) throws SQLException;

    List<Specialization> getSpecializationByName(String specializationName) throws SQLException;

    int countAllBySpecName(String specName) throws SQLException;
}
