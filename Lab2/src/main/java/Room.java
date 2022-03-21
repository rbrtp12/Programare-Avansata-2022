import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode

public class Room {
    private String roomName;
    private Integer roomSize;
    private Types roomType;


    public enum Types {
        LAB,
        LECTUREHALL,
    }


}
