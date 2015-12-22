package dao;

import model.Flight;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mykola- on 21.12.2015.
 */
public interface flightDAO extends BaseDAO<Flight> {

    List<Flight> getFlightById(String flight_id) throws SQLException;

    List<Flight> getFlightByDispatch(String dispatch) throws SQLException;

    List<Flight> getFlightByArrival(String arrival) throws SQLException;

    int countAllByDispatch(String dispatch) throws SQLException;

    int countAllByArrival(String arrival) throws SQLException;
}
