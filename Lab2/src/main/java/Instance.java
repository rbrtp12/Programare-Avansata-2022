import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Log

public class Instance {
    public void getInstance() {
        List<Event> eventList = new ArrayList<>();
        log.info(" Entering Main ");
        /**
         * generating events
         */
        log.info(" GENERATING EVENTS ");
        try {
            Event c1 = new Event("C1", 100, 8, 10);
            log.info(c1.toString());
            Event c2 = new Event("C2", 100, 10, 12);
            log.info(c2.toString());
            Event l1 = new Event("L1", 30, 8, 10);
            log.info(l1.toString());
            Event l2 = new Event("L2", 30, 8, 10);
            log.info(l2.toString());
            Event l3 = new Event("L3", 30, 10, 12);
            log.info(l3.toString());
            Event l4 = new Event("L3", 30, 10, 12);
            System.out.println(l4.equals(l3));
        }
        catch(Exception e){
            log.info("event already existing");
        }
        log.info(" EVENTS GENERATED ");

        /**
         * generating rooms
         */
        log.info(" GENERATING ROOMS ");
        Room r1 = new Room("401", 30, Room.Types.LAB);
        log.info(r1.toString());
        Room r2 = new Room("403", 30, Room.Types.LAB);
        log.info(r2.toString());
        Room r3 = new Room("405", 30, Room.Types.LAB);
        log.info(r3.toString());
        Room r4 = new Room("309", 100, Room.Types.LECTUREHALL);
        log.info(r4.toString());
        log.info(" ROOMS GENERATED ");
    }
}
