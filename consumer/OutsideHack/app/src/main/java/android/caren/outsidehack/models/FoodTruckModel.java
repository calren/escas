package android.caren.outsidehack.models;

import android.graphics.drawable.Drawable;
import android.view.View;

public class FoodTruckModel {

    private int id;
    private int picture;
    private String type;
    private double location;
    private int ordersAhead;
    private String name;
    private View.OnClickListener onClickListener;

    public FoodTruckModel(int id, int picture, String type, double location, int ordersAhead,
            String name, View.OnClickListener onClickListener) {
        this.id = id;
        this.picture = picture;
        this.type = type;
        this.location = location;
        this.ordersAhead = ordersAhead;
        this.name = name;
        this.onClickListener = onClickListener;
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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
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

    public double getLocation() {
        return location;
    }

    public void setLocation(double location) {
        this.location = location;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }
}
