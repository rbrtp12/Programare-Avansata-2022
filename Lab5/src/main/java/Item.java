import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Item implements Serializable {
    private String id;
    private String title;
    private String location;


}
