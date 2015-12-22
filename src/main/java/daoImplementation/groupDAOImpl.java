package daoImplementation;

import dao.BaseDAO;
import dao.groupDAO;
import model.Employee;
import model.Flight;
import model.Group;
import persistant.ConnectionManager;
import util.Constant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykola- on 22.12.2015.
 */
public class groupDAOImpl  implements groupDAO, BaseDAO<Group> {

    private PreparedStatement ps = null;
    private ResultSet rs;
    private static ConnectionManager connection = null;

    private groupDAOImpl() {
    }

    @Override
    public void create(Group group) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO group"
                + "(id, name) VALUES"
                + "(?,?)");
        ps.setObject(1, null);

        ps.executeQuery();
        ps.close();
    }


    @Override
    public Group findById(String grpId) throws SQLException {

        Group group = null;
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM group WHERE id=?;");
        ps.setString(1, grpId);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            group = new Group();
            group.setId(Integer.parseInt(Constant.Group.ID));
        }

        return group;

    }

    @Override
    public void delete(Group object) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM group WHERE id=?;");
        ps.setString(1, object.toString());

        ps.executeQuery();
        ps.close();
    }

    @Override
    public List<Group> getAll() throws SQLException {
        Group group = null;
        List<Group> grp = new ArrayList<Group>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM group;");
        ResultSet rs = ps.executeQuery();
        ps.close();

        while (rs.next()) {
            group = new Group();
            group.setId(Integer.parseInt(Constant.Group.ID));

            grp.add(group);
        }

        return grp;
    }

    @Override
    public void update(Group object) throws SQLException {

    }


    @Override
    public List<Group> getGroupById(String group_id) throws SQLException {
        Group group = null;
        List<Group> grp = new ArrayList<Group>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM group WHERE id=?;");
        ps.setString(1, group_id);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            group = new Group();
            group.setId(Integer.parseInt(Constant.Group.ID));

            grp.add(group);
        }
        return grp;
    }
}
