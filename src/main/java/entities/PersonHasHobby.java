package entities;

import javax.persistence.*;

@Entity
@Table(name = "person_has_hobby")
public class PersonHasHobby {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private PersonHasHobbyId id;

    @MapsId("personId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @MapsId("hobbyId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;

    public PersonHasHobbyId getId() {
        return id;
    }

    public void setId(PersonHasHobbyId id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

}