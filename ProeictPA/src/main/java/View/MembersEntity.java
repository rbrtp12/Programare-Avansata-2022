package View;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Members", schema = "STUDENT", catalog = "")
public class MembersEntity {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private BigInteger id;
    @Basic
    @Column(name = "NAME", nullable = true, length = 20)
    private String name;
    @Basic
    @Column(name = "ZODIAC_ID", nullable = true, precision = 0)
    private BigInteger zodiacId;

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

    public BigInteger getZodiacId() {
        return zodiacId;
    }

    public void setZodiacId(BigInteger zodiacId) {
        this.zodiacId = zodiacId;
    }
}
