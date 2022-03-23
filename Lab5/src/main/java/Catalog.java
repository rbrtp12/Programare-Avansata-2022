import lombok.*;
import lombok.extern.java.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Log
public class Catalog implements Serializable {
    private String title;
    private List<Item> items = new ArrayList<>();

    public Catalog(String title, List<Item> items) {
        this.title = title;
        this.items = items;
    }

    /**
     * adds item to catalog
     * @param item
     */
    public void addItem(Item item){
        items.add(item);
        log.info(item + " added to " + this.title);
    }

    public Item findById(String id){
        return items.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst().orElse(null);
    }
}
