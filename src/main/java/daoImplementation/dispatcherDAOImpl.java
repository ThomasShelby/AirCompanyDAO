package daoImplementation;

import dao.BaseDAO;
import dao.dispatcherDAO;
import model.Dispatcher;
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
public class dispatcherDAOImpl implements dispatcherDAO, BaseDAO<Dispatcher> {

    private PreparedStatement ps = null;
    private ResultSet rs;
    private static ConnectionManager connection = null;

    private dispatcherDAOImpl() {
    }

    @Override
    public void create(Dispatcher dispatcher) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO dispatcher"
                + "(id, name, login, password) VALUES"
                + "(?,?,?,?)");
        ps.setObject(1, null);
        ps.setString(2, dispatcher.getName());
        ps.setString(3, dispatcher.getLogin());
        ps.setString(4, dispatcher.getPassword());

        ps.executeQuery();
        ps.close();
    }


    @Override
    public void update(Dispatcher dispatcher) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE dispatcher SET name=?, login=?, password=? WHERE id=?;");
        ps.setString(1, dispatcher.getName());
        ps.setString(2, dispatcher.getLogin());
        ps.setString(3, dispatcher.getPassword());
        ps.setString(4, String.valueOf(dispatcher.getId()));

        ps.executeQuery();
        ps.close();
    }


    @Override
    public Dispatcher findById(String disp) throws SQLException {

        Dispatcher dispatcher = null;
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM dispatcher WHERE id=?;");
        ps.setString(1, disp);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            dispatcher = new Dispatcher();
            dispatcher.setId(Integer.parseInt(rs.getString(Constant.Dispatcher.ID)));
            dispatcher.setName(rs.getString(Constant.Dispatcher.NAME));
            dispatcher.setLogin(rs.getString(Constant.Dispatcher.LOGIN));
            dispatcher.setPassword(rs.getString(Constant.Dispatcher.PASSWORD));
        }

        return dispatcher;

    }

    @Override
    public void delete(Dispatcher object) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM dispatcher WHERE id=?;");
        ps.setString(1, object.toString());

        ps.executeQuery();
        ps.close();
    }

    @Override
    public List<Dispatcher> getAll() throws SQLException {
        Dispatcher dispatcher = null;
        List<Dispatcher> dispt = new ArrayList<Dispatcher>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM dispatcher;");
        rs = ps.executeQuery();
        ps.close();

        while (rs.next()) {
            dispatcher = new Dispatcher();
            dispatcher.setId(Integer.parseInt(rs.getString(Constant.Dispatcher.ID)));
            dispatcher.setName(rs.getString(Constant.Dispatcher.NAME));
            dispatcher.setLogin(rs.getString(Constant.Dispatcher.LOGIN));
            dispatcher.setPassword(rs.getString(Constant.Dispatcher.PASSWORD));

            dispt.add(dispatcher);
        }

        return dispt;
    }

    @Override
    public List<Dispatcher> getDispatcherByName(String dispatcherName) throws SQLException{
        Dispatcher dispatcher = null;
        List<Dispatcher> dispt = new ArrayList<Dispatcher>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM dispatcher WHERE name=?;");
        ps.setString(1, dispatcherName);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            dispatcher = new Dispatcher();
            dispatcher.setId(Integer.parseInt(rs.getString(Constant.Dispatcher.ID)));
            dispatcher.setName(rs.getString(Constant.Dispatcher.NAME));
            dispatcher.setLogin(rs.getString(Constant.Dispatcher.LOGIN));
            dispatcher.setPassword(rs.getString(Constant.Dispatcher.PASSWORD));

            dispt.add(dispatcher);
        }

        return dispt;
    }
}
