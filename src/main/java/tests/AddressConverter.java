package tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter
public class AddressConverter implements AttributeConverter<List<String>, String > {
    public AddressConverter() {
        System.err.println("New converter created");
    }

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return new Gson().toJson(attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return new Gson().fromJson(dbData,new TypeToken<List<String>>(){}.getType());
    }
}
