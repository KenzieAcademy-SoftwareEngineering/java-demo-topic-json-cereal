import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {

        //TODO: De-serialize: Map a single Cereal object to a DTO
        File oneCerealFile = new File("cereal_one.json");

        ObjectMapper objectMapper = new ObjectMapper();
        CerealDTO oneCereal = objectMapper.readValue(oneCerealFile,CerealDTO.class);

        System.out.println(oneCereal.getName());
        System.out.println(oneCereal.getMarshmallows());

        //Update CerealDTO
        System.out.println(oneCereal.getCalories());
        oneCereal.setCalories(200.5);
        System.out.println(oneCereal.getCalories());

        //Serialization: Writing out the JSON String from the CerealDTO Class
        // configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String cerealStr = objectMapper.writeValueAsString(oneCereal);
        System.out.println(cerealStr);

        //Is marshmallows set to an ArrayList?
        if (oneCereal.getMarshmallows() instanceof ArrayList){

            System.out.println("I'm an ArrayList");
        }


        //TODO: Map a List of Cereal objects from JSON to a List of DTOs
        File manyCerealFile = new File("cereal_many.json");

        ObjectMapper objectMapper2 = new ObjectMapper();
        TypeReference<List<CerealDTO>> typeReferenceForCerealList = new TypeReference<>(){};

        List<CerealDTO> manyCerealList = objectMapper2.readValue(manyCerealFile,typeReferenceForCerealList);

        if (manyCerealList instanceof ArrayList) {
            System.out.println("I'm a CerealDTO ArrayList");
        }
        System.out.println(manyCerealList.toString());

        for (CerealDTO cereal : manyCerealList){
            System.out.println(cereal.getName());
            System.out.println(cereal.getMarshmallows());
        }

    }
}

class CerealDTO {
    //Sample JSON:
   /*
   {
       "id": 100,
       "type": "cereal",
       "name"  : "Lucky Charms",
       "base": "oat",
       "calories"  : 120.5,
       "marshmallows" : [ "hearts", "stars", "rainbows", "clovers" ]
   }
   */
    private int id;
    private String type;
    private String name;
    private String base;
    private double calories;
    private List<String> marshmallows;

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

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public List<String> getMarshmallows() {
        return marshmallows;
    }

    public void setMarshmallows(List<String> marshmallows) {
        this.marshmallows = marshmallows;
    }
}
