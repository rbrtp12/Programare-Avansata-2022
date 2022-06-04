package Views;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CapitalsView {
    private int id;
    private String name;
    private Float latitude;
    private Float longitude;
    private int country;
}
