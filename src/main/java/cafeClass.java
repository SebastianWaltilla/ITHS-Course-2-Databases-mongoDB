package main.java;

public class cafeClass {

    String _id;
    String name;
    int stars;
    String[] categories;


    public cafeClass(String _id, String name, int stars) {
        this._id = _id;
        this.name = name;
        this.stars = stars;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
