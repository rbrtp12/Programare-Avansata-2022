package View;

import javax.persistence.*;

@Entity
@Table(name = "members", schema = "heroku_001ae26eae7ca64")
public class MembersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Basic
    @Column(name = "zodiacId", nullable = true)
    private Integer zodiacId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZodiacId() {
        return zodiacId;
    }

    public void setZodiacId(Integer zodiacId) {
        this.zodiacId = zodiacId;
    }
}
