package hello.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GreetingSomeone implements Serializable{

    private long id;
    private String fromName;
    private String name;

    @JsonCreator
    public GreetingSomeone(@JsonProperty("id") long id,
                           @JsonProperty("fromName") String fromName,
                           @JsonProperty("name") String name) {
        this.id = id;
        this.fromName = fromName;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFromName() {
        return fromName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
