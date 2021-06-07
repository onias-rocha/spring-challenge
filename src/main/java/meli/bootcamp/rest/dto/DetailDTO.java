package meli.bootcamp.rest.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import meli.bootcamp.entity.Type;

import java.io.Serializable;

@Data
public class DetailDTO implements Serializable {
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    @Override
    public String toString() {
        return "DetailDTO{" +
                "productName='" + productName + '\'' + "\n" +
                ", type=" + type + "\n" +
                ", brand='" + brand + '\'' + "\n" +
                ", color='" + color + '\'' + "\n" +
                ", notes='" + notes + '\'' +
                '}';
    }
}
