package models;

public class Bussines {
    private String name;
    private String address;
    private String city;
    private String state;

    public Bussines(String name, String address, String city, String state) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Bussines [Name=" + name + ", Address=" + address + ", City=" + city + ", State= " + state+"]";
    }

}