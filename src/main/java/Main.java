import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
     try {
         //TODO: De-serialize: Map a single Cereal object to a DTO
         File oneCerealFile = new File("cereal_two.json");

         //object that helps us map
         ObjectMapper mapper = new ObjectMapper();

         //OVERLOADED readValue()
         CerealDTO cereal = mapper.readValue(oneCerealFile, CerealDTO.class);

         System.out.println(cereal);

         //Parse an unnamed list into a DTO
         File unnamedListCerealFile = new File("cereal_list.json");

         //object mapper to help map
         ObjectMapper mapper2 = new ObjectMapper();

         TypeReference<List<CerealUnnamedListDTO>> typeReferenceListCerealDTO =  new TypeReference<>(){};
         // TypeReference<Type>

         List<CerealUnnamedListDTO> cerealList = mapper2.readValue(unnamedListCerealFile,typeReferenceListCerealDTO );

         System.out.println(cerealList);

         //*** Example 3 ***/
         //Parse a named list into an object
         File namedListCerealFile = new File("cereal_named_list.json");

         //instance of mapper
         ObjectMapper mapper3 = new ObjectMapper();

         // Use readValue() to read into a DTO
         CerealNamedListDTO namedCereals = mapper3.readValue(namedListCerealFile, CerealNamedListDTO.class);

         System.out.println(namedCereals);

     }
     catch(Exception e){
         System.out.println(e);
     }

    }

}

