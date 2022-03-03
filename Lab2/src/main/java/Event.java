import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor


public class Event {
    private String eventName;
    private Integer eventSize;
    private Integer startEvent;
    private Integer endEvent;


}
