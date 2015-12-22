package dao;

import model.Dispatcher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mykola- on 21.12.2015.
 */
public interface dispatcherDAO extends BaseDAO<Dispatcher> {

    List<Dispatcher> getDispatcherByName(String dispatcher_name)throws SQLException;

    //void invalidateSession(String dispatcherId, String session);
}
