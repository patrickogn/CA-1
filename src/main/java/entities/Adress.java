package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "adress")
public class Adress {
    @Id
    @Column(name = "adress_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "street", nullable = false, length = 45)
    private String street;

    @Size(max = 45)
    @NotNull
    @Column(name = "additionalinfo", nullable = false, length = 45)
    private String additionalinfo;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zipcode", nullable = false)
    private Cityinfo cityinfo;

    public Adress() {
    }

    public Adress(String street, String additionalinfo, Cityinfo cityinfo) {
        this.street = street;
        this.additionalinfo = additionalinfo;
        this.cityinfo = cityinfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

}