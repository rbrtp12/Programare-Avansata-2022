package compulsory;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Catalog implements Serializable {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
