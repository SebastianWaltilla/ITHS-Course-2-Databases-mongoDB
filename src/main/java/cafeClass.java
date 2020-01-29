package main.java;

import java.util.ArrayList;

public class cafeClass {

    String _id;
    String name;
    int stars;
    ArrayList<String> categories;


    public cafeClass(String _id, String name, int stars) {
        this._id = _id;
        this.name = name;
        this.stars = stars;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }
}
