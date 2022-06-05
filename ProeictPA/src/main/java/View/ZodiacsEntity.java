package View;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Zodiacs", schema = "STUDENT", catalog = "")
public class ZodiacsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private BigInteger id;
    @Basic
    @Column(name = "NAME", nullable = true, length = 20)
    private String name;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
