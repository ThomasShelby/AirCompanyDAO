package model;

import java.sql.Timestamp;

public class Flight {

    private Integer id;
    private String dispatch;
    private String arrival;
    private Timestamp dispDate;
    private Timestamp arrDate;
    private Integer dispatcher_id;
    private Integer group_id;

    public Flight() {
    }

    public Flight(Integer id, String dispatch, String arrival, Timestamp dispDate,
                  Timestamp arrDate, Integer dispatcher_id, Integer group_id) {
        this.id = id;
        this.dispatch = dispatch;
        this.arrival = arrival;
        this.dispDate = dispDate;
        this.arrDate = arrDate;
        this.dispatcher_id = dispatcher_id;
        this.group_id = group_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (id != null ? !id.equals(flight.id) : flight.id != null) return false;
        if (dispatch != null ? !dispatch.equals(flight.dispatch) : flight.dispatch != null) return false;
        if (arrival != null ? !arrival.equals(flight.arrival) : flight.arrival != null) return false;
        if (dispatcher_id != null ? !dispatcher_id.equals(flight.dispatcher_id) : flight.dispatcher_id != null)
            return false;
        return !(group_id != null ? !group_id.equals(flight.group_id) : flight.group_id != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dispatch != null ? dispatch.hashCode() : 0);
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        result = 31 * result + (dispatcher_id != null ? dispatcher_id.hashCode() : 0);
        result = 31 * result + (group_id != null ? group_id.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDispatch() {
        return dispatch;
    }

    public void setDispatch(String dispatch) {
        this.dispatch = dispatch;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Timestamp getDispDate() {
        return dispDate;
    }

    public void setDispDate(Timestamp dispDate) {
        this.dispDate = dispDate;
    }

    public Timestamp getArrDate() {
        return arrDate;
    }

    public void setArrDate(Timestamp arrDate) {
        this.arrDate = arrDate;
    }

    public Integer getDispatcher_id() {
        return dispatcher_id;
    }

    public void setDispatcher_id(Integer dispatcher_id) {
        this.dispatcher_id = dispatcher_id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }
}
