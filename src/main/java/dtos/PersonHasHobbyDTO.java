package dtos;

import entities.Hobby;
import entities.Person;
import entities.PersonHasHobby;
import entities.PersonHasHobbyId;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.PersonHasHobby} entity
 */
public class PersonHasHobbyDTO implements Serializable {
    private final PersonHasHobbyId id;
    private final Person person;
    private final Hobby hobby;


    public PersonHasHobbyDTO(PersonHasHobby personHasHobby) {
        this.id = personHasHobby.getId();
        this.person = personHasHobby.getPerson();
        this.hobby = personHasHobby.getHobby();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonHasHobbyDTO entity = (PersonHasHobbyDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.person, entity.person) &&
                Objects.equals(this.hobby, entity.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, hobby);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "person = " + person + ", " +
                "hobby = " + hobby + ")";
    }

    /**
     * A DTO for the {@link entities.PersonHasHobbyId} entity
     */
    public static class PersonHasHobbyIdDTO implements Serializable {
        @NotNull
        private final Integer personId;
        @NotNull
        private final Integer hobbyId;

        public PersonHasHobbyIdDTO(Integer personId, Integer hobbyId) {
            this.personId = personId;
            this.hobbyId = hobbyId;
        }

        public Integer getPersonId() {
            return personId;
        }

        public Integer getHobbyId() {
            return hobbyId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonHasHobbyIdDTO entity = (PersonHasHobbyIdDTO) o;
            return Objects.equals(this.personId, entity.personId) &&
                    Objects.equals(this.hobbyId, entity.hobbyId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(personId, hobbyId);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "personId = " + personId + ", " +
                    "hobbyId = " + hobbyId + ")";
        }
    }

    public static List<PersonHasHobbyDTO> getphhDTOs(List<PersonHasHobby> personHasHobbies){
        List<PersonHasHobbyDTO> personHasHobbyDTOList = new ArrayList<>();
        personHasHobbies.forEach(p -> personHasHobbyDTOList.add(new PersonHasHobbyDTO(p)));
        return personHasHobbyDTOList;
    }
}