package daoImplementation;

import dao.BaseDAO;
import dao.specializationDAO;
import model.Employee;
import model.Specialization;
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
public class specializationDAOImpl implements specializationDAO, BaseDAO<Specialization> {

    private PreparedStatement ps = null;
    private ResultSet rs;

    private specializationDAOImpl() {
    }

    @Override
    public void create(Specialization specialization) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO specialization (id, name) VALUES (?,?)");
        ps.setObject(1, null);
        ps.setString(2, specialization.getName());

        ps.executeQuery();
        ps.close();
    }


    @Override
    public void update(Specialization specialization) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("update specialization set name=? WHERE id=?;");
        ps.setString(1, specialization.getName());
        ps.setString(2, (String.valueOf(specialization.getId())));

        ps.executeQuery();
        ps.close();
    }


    @Override
    public Specialization findById(String spId) throws SQLException {

        Specialization specialization = null;
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM specialization WHERE id=?;");
        ps.setString(1, spId);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            specialization = new Specialization();
            specialization.setId(Integer.parseInt(Constant.Specialization.ID));
            specialization.setName(Constant.Specialization.NAME);
        }

        return specialization;

    }

    @Override
    public void delete(Specialization object) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM specialization WHERE id=?;");
        ps.setString(1, object.toString());

        ps.executeQuery();
        ps.close();
    }

    @Override
    public List<Specialization> getAll() throws SQLException {
        Specialization specialization = null;
        List<Specialization> splz = new ArrayList<Specialization>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM specialization;");
        ResultSet rs = ps.executeQuery();
        ps.close();

        while (rs.next()) {
            specialization = new Specialization();
            specialization.setId(Integer.parseInt(Constant.Specialization.ID));
            specialization.setName(Constant.Specialization.NAME);

            splz.add(specialization);
        }

        return splz;
    }

    @Override
    public List<Specialization> getSpecializationByName(String specializationName) throws SQLException{

        Specialization specialization = null;
        List<Specialization> splz = new ArrayList<Specialization>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM specialization WHERE name=?;");
        ps.setString(1, specializationName);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            specialization = new Specialization();
            specialization.setId(Integer.parseInt(Constant.Specialization.ID));
            specialization.setName(Constant.Specialization.NAME);

            splz.add(specialization);
        }

        return splz;
    }

    @Override
    public List<Specialization> getSpecializationById(String specialization_id) throws SQLException{

        Specialization specialization = null;
        List<Specialization> splz = new ArrayList<Specialization>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM specialization WHERE id=?;");
        ps.setString(1, specialization_id);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            specialization = new Specialization();
            specialization.setId(Integer.parseInt(Constant.Specialization.ID));
            specialization.setName(Constant.Specialization.NAME);

            splz.add(specialization);
        }

        return splz;
    }

    @Override
    public int countAllBySpecName(String specName) throws SQLException{
        int users = 0;

        Connection conn = ConnectionManager.getConnection();
        ps = conn.prepareStatement(
                "select COUNT(*) AS id from specialization where name =? group by name;");
        ps.setString(1, specName.toUpperCase());
        rs = ps.executeQuery();
        while (rs.next()) {
            users = rs.getInt(Constant.Specialization.ID);
        }

        return users;
    }

}
