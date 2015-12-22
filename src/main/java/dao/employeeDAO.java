package dao;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mykola- on 21.12.2015.
 */
public interface employeeDAO extends BaseDAO<Employee> {

    List<Employee> getEmployeeByName(String employee_name) throws SQLException;

   // void invalidateSession(String employeeId, String session);
}
