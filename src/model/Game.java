package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("component")
    private int component;

    @JsonCreator
    public Game(@JsonProperty("name") String name, @JsonProperty("component") int component) {
        this.name = name;
        this.component = component;
    }

    @JsonCreator
    public Game(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("component") int component
    ) {
        this.id = id;
        this.name = name;
        this.component = component;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("component")
    public int getComponentId() {
        return component;
    }
}
