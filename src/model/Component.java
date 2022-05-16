package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Component {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;


    public Component(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Component(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
