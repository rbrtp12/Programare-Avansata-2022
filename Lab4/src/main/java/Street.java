import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Street implements Comparable<Street>{
    private String streetName;
    private int streetLenght;

    @Override
    public int compareTo(Street o) {
        if (streetLenght == o.getStreetLenght())
            return 0;
            else if (streetLenght > o.getStreetLenght())
                return 1;
            else return -1;

    }
}
