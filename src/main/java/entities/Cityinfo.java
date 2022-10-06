package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "cityinfo")
public class Cityinfo {
    @Id
    @Column(name = "zipcode", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    public Cityinfo(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    public Cityinfo() {

    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cityinfo cityinfo = (Cityinfo) o;
        return Objects.equals(id, cityinfo.id) && Objects.equals(city, cityinfo.city);
    }

    @Override
    public String toString()
    {
        return "Cityinfo{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, city);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}