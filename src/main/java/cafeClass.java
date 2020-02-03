package main.java;
import java.util.ArrayList;

// the cafe class holds every cafe document and its information
public class cafeClass {

    private String _id;
    private String name;
    private int stars;
    private ArrayList<String> categories = new ArrayList<String>();

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

    public void addToCategories(String string){
        this.categories.add(string);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }


}
