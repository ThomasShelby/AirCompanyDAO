package dao;

import model.Group;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mykola- on 22.12.2015.
 */
public interface groupDAO extends BaseDAO<Group> {

    List<Group> getGroupById(String group_id) throws SQLException;
}
