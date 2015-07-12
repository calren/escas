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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodTruckModel that = (FoodTruckModel) o;

        if (id != that.id) return false;
        if (picture != that.picture) return false;
        if (Double.compare(that.location, location) != 0) return false;
        if (ordersAhead != that.ordersAhead) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + picture;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(location);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ordersAhead;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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
