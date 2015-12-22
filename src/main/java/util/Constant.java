package util;

/**
 * Created by Mykola- on 22.12.2015.
 */
public class Constant {

    public static class Dispatcher{
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
    }

    public static class Employee{
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String LAST_NAME = "last_name";
        public static final String SPEC_ID = "spec_id";
        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
        public static final String GROUP_ID = "group_id";
    }

    public static class Flight{
        public static final String ID = "id";
        public static final String DISPATCH = "dispatch";
        public static final String ARRIVAL = "arrival";
        public static final String GROUP_ID = "group_id";
        public static final String DISP_DATE = "disp_date";
        public static final String ARR_DATE = "arr_date";
        public static final String DISPATCHER_ID = "dispatcher_id";
    }

    public static class Group{
        public static final String ID = "id";
    }

    public static class Specialization{
        public static final String ID = "id";
        public static final String NAME = "name";
    }
}
