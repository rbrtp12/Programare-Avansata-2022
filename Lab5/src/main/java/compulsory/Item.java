package compulsory;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class Item implements Serializable {
    private String id;
    private String title;
    private String location;

    private Map<String, Object> tags = new HashMap<>();

    public Item(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
}