import lombok.*;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Log

public class Event {
    private String eventName;
    private Integer eventSize;
    private Integer startEvent;
    private Integer endEvent;


    public Event(String eventName, Integer eventSize, Integer startEvent, Integer endEvent) throws Exception {

        for (int i = 0; i < this.eventList.size(); i++) {
            if (this.equals(eventList.get(i)))
                throw new CloneNotSupportedException("You cannot have two identical events");
            else {
                this.eventName = eventName;
                this.eventSize = eventSize;
                this.startEvent = startEvent;
                this.endEvent = endEvent;
                eventList.add(this.eventList.get(i));
            }
        }

    }
}

