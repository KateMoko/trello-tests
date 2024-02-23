package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardModel {

    private String id;
    private String name;
    private String idList;
    private String idBoard;
    private Boolean closed;
}
