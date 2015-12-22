package daoImplementation;

import dao.BaseDAO;
import dao.flightDAO;
import model.Flight;
import persistant.ConnectionManager;
import util.Constant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykola- on 22.12.2015.
 */
public class flightDAOImpl implements flightDAO, BaseDAO<Flight> {

    private PreparedStatement ps = null;
    private ResultSet rs;
    private static ConnectionManager connection = null;

    private flightDAOImpl() {
    }

    @Override
    public void create(Flight flight) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO flight"
                + "(id, dispatch, arrival, group_id, disp_date, arr_date, dispatcher_id) VALUES"
                + "(?,?,?,?,?,?,?)");
        ps.setObject(1, null);
        ps.setString(2, flight.getDispatch());
        ps.setString(3, flight.getArrival());
        ps.setString(4, (String.valueOf(flight.getGroup_id())));
        ps.setString(5, String.valueOf(flight.getDispDate()));
        ps.setString(6, String.valueOf(flight.getArrDate()));
        ps.setString(7, (String.valueOf(flight.getDispatcher_id())));

        ps.executeQuery();
        ps.close();
    }


    @Override
    public void update(Flight flight) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("update flight set dispatch=?, arrival=?, group_id=?, disp_date=?, arr_date=?, dispatcher_id=? WHERE id=?;");
        ps.setString(1, flight.getDispatch());
        ps.setString(2, flight.getArrival());
        ps.setString(3, (String.valueOf(flight.getGroup_id())));
        ps.setString(4, String.valueOf(flight.getDispDate()));
        ps.setString(5, String.valueOf(flight.getArrDate()));
        ps.setString(6, (String.valueOf(flight.getDispatcher_id())));
        ps.setString(7, (String.valueOf(flight.getId())));

        ps.executeQuery();
        ps.close();
    }


    @Override
    public Flight findById(String flg) throws SQLException {

        Flight flight = null;
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM flight WHERE id=?;");
        ps.setString(1, flg);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            flight = new Flight();
            flight.setId(Integer.parseInt(Constant.Flight.ID));
            flight.setDispatch(Constant.Flight.DISPATCH);
            flight.setArrival(Constant.Flight.ARRIVAL);
            flight.setGroup_id(Integer.parseInt(Constant.Flight.GROUP_ID));
            flight.setDispDate(Timestamp.valueOf(Constant.Flight.DISP_DATE));
            flight.setArrDate(Timestamp.valueOf(Constant.Flight.ARR_DATE));
            flight.setDispatcher_id(Integer.parseInt(Constant.Flight.DISPATCHER_ID));
        }

        return flight;

    }

    @Override
    public void delete(Flight object) throws SQLException {

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM flight WHERE id=?;");
        ps.setString(1, object.toString());

        ps.executeQuery();
        ps.close();
    }

    @Override
    public List<Flight> getAll() throws SQLException {
        Flight flight = null;
        List<Flight> flg = new ArrayList<Flight>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee;");
        ResultSet rs = ps.executeQuery();
        ps.close();

        while (rs.next()) {
            flight = new Flight();
            flight.setId(Integer.parseInt(Constant.Flight.ID));
            flight.setDispatch(Constant.Flight.DISPATCH);
            flight.setArrival(Constant.Flight.ARRIVAL);
            flight.setGroup_id(Integer.parseInt(Constant.Flight.GROUP_ID));
            flight.setDispDate(Timestamp.valueOf(Constant.Flight.DISP_DATE));
            flight.setArrDate(Timestamp.valueOf(Constant.Flight.ARR_DATE));
            flight.setDispatcher_id(Integer.parseInt(Constant.Flight.DISPATCHER_ID));

            flg.add(flight);
        }

        return flg;
    }

    @Override
    public List<Flight> getFlightByDispatch(String FlightDispatch) throws SQLException{
        Flight flight = null;
        List<Flight> flg = new ArrayList<Flight>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM flight WHERE dispatch=?;");
        ps.setString(1, FlightDispatch);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            flight = new Flight();
            flight.setId(Integer.parseInt(Constant.Flight.ID));
            flight.setDispatch(Constant.Flight.DISPATCH);
            flight.setArrival(Constant.Flight.ARRIVAL);
            flight.setGroup_id(Integer.parseInt(Constant.Flight.GROUP_ID));
            flight.setDispDate(Timestamp.valueOf(Constant.Flight.DISP_DATE));
            flight.setArrDate(Timestamp.valueOf(Constant.Flight.ARR_DATE));
            flight.setDispatcher_id(Integer.parseInt(Constant.Flight.DISPATCHER_ID));

            flg.add(flight);
        }

        return flg;
    }

    @Override
    public List<Flight> getFlightByArrival(String FlightArrival) throws SQLException{
        Flight flight = null;
        List<Flight> flg = new ArrayList<Flight>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM flight WHERE arrival=?;");
        ps.setString(1, FlightArrival);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            flight = new Flight();
            flight.setId(Integer.parseInt(Constant.Flight.ID));
            flight.setDispatch(Constant.Flight.DISPATCH);
            flight.setArrival(Constant.Flight.ARRIVAL);
            flight.setGroup_id(Integer.parseInt(Constant.Flight.GROUP_ID));
            flight.setDispDate(Timestamp.valueOf(Constant.Flight.DISP_DATE));
            flight.setArrDate(Timestamp.valueOf(Constant.Flight.ARR_DATE));
            flight.setDispatcher_id(Integer.parseInt(Constant.Flight.DISPATCHER_ID));

            flg.add(flight);
        }

        return flg;
    }

    public List<Flight> getFlightById(String flightId) throws SQLException{
        Flight flight = null;
        List<Flight> flg = new ArrayList<Flight>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT FROM flight WHERE id=?;");
        ps.setString(1, flightId);

        ps.executeQuery();
        ps.close();

        while (rs.next()) {
            flight = new Flight();
            flight.setId(Integer.parseInt(Constant.Flight.ID));
            flight.setDispatch(Constant.Flight.DISPATCH);
            flight.setArrival(Constant.Flight.ARRIVAL);
            flight.setGroup_id(Integer.parseInt(Constant.Flight.GROUP_ID));
            flight.setDispDate(Timestamp.valueOf(Constant.Flight.DISP_DATE));
            flight.setArrDate(Timestamp.valueOf(Constant.Flight.ARR_DATE));
            flight.setDispatcher_id(Integer.parseInt(Constant.Flight.DISPATCHER_ID));

            flg.add(flight);
        }

        return flg;
    }

    public int countAllByDispatch(String dispatch) throws SQLException{
            int users = 0;

                Connection conn = ConnectionManager.getConnection();
                ps = conn.prepareStatement(
                        "select COUNT(*) AS id from flight where dispatch =? group by dispatch;");
                ps.setString(1, dispatch.toUpperCase());
                rs = ps.executeQuery();
                while (rs.next()) {
                    users = rs.getInt(Constant.Flight.ID);
                }

            return users;
    }

    public int countAllByArrival(String arrival) throws SQLException{
        int users = 0;

        Connection conn = ConnectionManager.getConnection();
        ps = conn.prepareStatement(
                "select COUNT(*) AS id from flight where arrival =? group by arrival;");
        ps.setString(1, arrival.toUpperCase());
        rs = ps.executeQuery();
        while (rs.next()) {
            users = rs.getInt(Constant.Flight.ID);
        }

        return users;
    }
}
