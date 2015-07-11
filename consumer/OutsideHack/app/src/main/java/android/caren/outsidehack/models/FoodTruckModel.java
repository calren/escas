package android.caren.outsidehack.models;

public class FoodTruckModel {

    private int id;
    private String picture;
    private String type;
    private String location;
    private int ordersAhead;
    private String name;

    public FoodTruckModel(int id, String picture, String type, String location, int ordersAhead, String name) {
        this.id = id;
        this.picture = picture;
        this.type = type;
        this.location = location;
        this.ordersAhead = ordersAhead;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOrdersAhead() {
        return ordersAhead;
    }

    public void setOrdersAhead(int ordersAhead) {
        this.ordersAhead = ordersAhead;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
