import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CerealDTO {
   private int id;
   private String type;
   private String name;
   private double calories;
   private String base;
   private ArrayList<String> marshmallows;
   private String toy;

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public ArrayList<String> getMarshmallows() {
        return marshmallows;
    }

    public void setMarshmallows(ArrayList<String> marshmallows) {
        this.marshmallows = marshmallows;
    }

    @Override
    public String toString() {
        return "CerealDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", base='" + base + '\'' +
                ", marshmallows=" + marshmallows +
                ", toy='" + toy + '\'' +
                '}';
    }
}
