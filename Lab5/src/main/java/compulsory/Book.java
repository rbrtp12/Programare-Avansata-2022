package compulsory;

import homework.InvalidBookArguments;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Item {
    private String author;
    private int year;
    private int pageNumber;

    public Book(String id, String title, String location, String author, int year, int pageNumber) {
        super(id, title, location);
        try {
            if (year > 2022 || pageNumber < 0)
                throw new InvalidBookArguments(new Exception());
            else {
                this.author = author;
                this.year = year;
                this.pageNumber = pageNumber;
            }
        } catch (InvalidBookArguments e) {
            e.printStackTrace();
        }
    }
}
