import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Room {
    private String roomName;
    private Integer roomSize;
    private Types roomType;


    public enum Types {
        LAB,
        LECTUREHALL,
    }


}
