package VIEWS;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAPITALS", schema = "STUDENT")
public class CapitalsEntity {
    private long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private int country;

    @Id
    @GeneratedValue(generator = "SQ_CAPITALS", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "LATITUDE", nullable = true, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "LONGITUDE", nullable = true, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    @JoinColumn(name = "COUNTRY")
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapitalsEntity that = (CapitalsEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude);
    }
}
