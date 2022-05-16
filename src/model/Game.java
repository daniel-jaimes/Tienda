package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("component")
    private Component component;

    public Game(@JsonProperty("name") String name, @JsonProperty("component") Component component) {
        this.name = name;
        this.component = component;
    }

    public Game(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("component") Component component
    ) {
        this.id = id;
        this.name = name;
        this.component = component;
    }
}
