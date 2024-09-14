package co2103.hw1.domain;

import java.util.List;

public class Depot {
    private int id;
    private String location;
    private String owner;
    private List<Bus> buses;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public String getOwner() {

        return owner;
    }

    public void setOwner(String owner) {

        this.owner = owner;
    }

    public List<Bus> getBuses() {

        return buses;
    }

    public void setBuses(List<Bus> buses) {

        this.buses = buses;
    }
}
