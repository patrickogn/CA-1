package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonHasHobbyId implements Serializable {
    private static final long serialVersionUID = 6003598901661957887L;
    @NotNull
    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @NotNull
    @Column(name = "hobby_id", nullable = false)
    private Integer hobbyId;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Integer hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonHasHobbyId entity = (PersonHasHobbyId) o;
        return Objects.equals(this.hobbyId, entity.hobbyId) &&
                Objects.equals(this.personId, entity.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hobbyId, personId);
    }

}