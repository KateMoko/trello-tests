package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListModel {

    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
}