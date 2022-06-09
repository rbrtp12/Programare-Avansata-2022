package compulsory;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Painting extends Item {
    private String painter;
    private int year;
    private String type;

    public Painting(String id, String title, String location, String painter, int year, String type) {
        super(id, title, location);
        this.painter = painter;
        this.year = year;
        this.type = type;
    }
}
