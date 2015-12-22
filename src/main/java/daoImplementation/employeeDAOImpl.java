package daoImplementation;

import dao.BaseDAO;
import dao.employeeDAO;
import model.Employee;
import persistant.ConnectionManager;
import util.Constant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykola- on 22.12.2015.
 */
public class employeeDAOImpl implements employeeDAO, BaseDAO<Employee> {

    private PreparedStatement ps = null;
    private ResultSet rs;
    private static ConnectionManager connection = null;

    private employeeDAOImpl() {
    }

    @Override
    public void create(Employee employee) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO employee"
                + "(id, name, last_name, spec_id, login, password, group_id) VALUES"
                + "(?,?,?,?,?,?,?)");
        ps.setObject(1, null);
        ps.setString(2, employee.getName());
        ps.setString(3, employee.getLastName());
        ps.setString(4, (String.valueOf(employee.getSpec_id())));
        ps.setString(5, employee.getLogin());
        ps.setString(6, employee.getPassword());
        ps.setString(7, (String.valueOf(employee.getGroup_id())));

        ps.executeQuery();
        ps.close();
    }


    @Override
    public void update(Employee employee) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("update employee set name=?, last_name=?, spec_id=?, login=?, password=?, group_id=? WHERE id=?;");
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, (String.valueOf(employee.getSpec_id())));
        ps.setString(4, employee.getLogin());
        ps.setString(5, (employee.getPassword()));
        ps.setString(6, (String.valueOf(employee.getGroup_id())));
        ps.setString(7, (String.valueOf(employee.getId())));

        ps.executeQuery();
        ps.close();
    }


    @Override
    public Employee findById(String empId) throws SQLException {

        Employee employee = null;
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM employee WHERE id=?;");
        ps.setString(1, empId);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            employee = new Employee();
            employee.setId(Integer.parseInt(Constant.Employee.ID));
            employee.setName(Constant.Employee.NAME);
            employee.setLastName(Constant.Employee.LAST_NAME);
            employee.setSpec_id(Integer.parseInt(Constant.Employee.SPEC_ID));
            employee.setLogin(Constant.Employee.LOGIN);
            employee.setPassword(Constant.Employee.PASSWORD);
            employee.setGroup_id(Integer.parseInt(Constant.Employee.GROUP_ID));
        }

        return employee;

    }

    @Override
    public void delete(Employee object) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE id=?;");
        ps.setString(1, object.toString());

        ps.executeQuery();
        ps.close();
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        Employee employee = null;
        List<Employee> empls = new ArrayList<Employee>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee;");
        ResultSet rs = ps.executeQuery();
        ps.close();

        while (rs.next()) {
            employee = new Employee();
            employee.setId(Integer.parseInt(Constant.Employee.ID));
            employee.setName(Constant.Employee.NAME);
            employee.setLastName(Constant.Employee.LAST_NAME);
            employee.setSpec_id(Integer.parseInt(Constant.Employee.SPEC_ID));
            employee.setLogin(Constant.Employee.LOGIN);
            employee.setPassword(Constant.Employee.PASSWORD);
            employee.setGroup_id(Integer.parseInt(Constant.Employee.GROUP_ID));

            empls.add(employee);
        }

        return empls;
    }

    @Override
    public List<Employee> getEmployeeByName(String employeeName) throws SQLException{
        Employee employee = null;
        List<Employee> empls = new ArrayList<Employee>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM employee WHERE name=?;");
        ps.setString(1, employeeName);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            employee = new Employee();
            employee.setId(Integer.parseInt(Constant.Employee.ID));
            employee.setName(Constant.Employee.NAME);
            employee.setLastName(Constant.Employee.LAST_NAME);
            employee.setSpec_id(Integer.parseInt(Constant.Employee.SPEC_ID));
            employee.setLogin(Constant.Employee.LOGIN);
            employee.setPassword(Constant.Employee.PASSWORD);
            employee.setGroup_id(Integer.parseInt(Constant.Employee.GROUP_ID));

            empls.add(employee);
        }

        return empls;
    }
}
