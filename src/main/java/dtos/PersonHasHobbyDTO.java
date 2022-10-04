package dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.PersonHasHobby} entity
 */
public class PersonHasHobbyDTO implements Serializable {
    private final PersonHasHobbyIdDTO id;
    private final PersonInnerDTO person;
    private final HobbyInnerDTO hobby;

    public PersonHasHobbyDTO(PersonHasHobbyIdDTO id, PersonInnerDTO person, HobbyInnerDTO hobby) {
        this.id = id;
        this.person = person;
        this.hobby = hobby;
    }

    public PersonHasHobbyIdDTO getId() {
        return id;
    }

    public PersonInnerDTO getPerson() {
        return person;
    }

    public HobbyInnerDTO getHobby() {
        return hobby;
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

    /**
     * A DTO for the {@link entities.Person} entity
     */
    public static class PersonInnerDTO implements Serializable {
        private final Integer id;
        @Size(max = 45)
        @NotNull
        private final String email;
        @Size(max = 45)
        @NotNull
        private final String gender;
        @NotNull
        private final Integer age;
        @Size(max = 45)
        @NotNull
        private final String firstName;
        @Size(max = 45)
        @NotNull
        private final String lastName;
        private final List<String> adresses;
        private final List<String> hobbys;
        private final List<String> phonenumbers;

        public PersonInnerDTO(Integer id, String email, String gender, Integer age, String firstName, String lastName, List<String> adresses, List<String> hobbys, List<String> phonenumbers) {
            this.id = id;
            this.email = email;
            this.gender = gender;
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
            this.adresses = adresses;
            this.hobbys = hobbys;
            this.phonenumbers = phonenumbers;
        }

        public Integer getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getGender() {
            return gender;
        }

        public Integer getAge() {
            return age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public List<String> getAdresses() {
            return adresses;
        }

        public List<String> getHobbys() {
            return hobbys;
        }

        public List<String> getPhonenumbers() {
            return phonenumbers;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonInnerDTO entity = (PersonInnerDTO) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.email, entity.email) &&
                    Objects.equals(this.gender, entity.gender) &&
                    Objects.equals(this.age, entity.age) &&
                    Objects.equals(this.firstName, entity.firstName) &&
                    Objects.equals(this.lastName, entity.lastName) &&
                    Objects.equals(this.adresses, entity.adresses) &&
                    Objects.equals(this.hobbys, entity.hobbys) &&
                    Objects.equals(this.phonenumbers, entity.phonenumbers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, email, gender, age, firstName, lastName, adresses, hobbys, phonenumbers);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "email = " + email + ", " +
                    "gender = " + gender + ", " +
                    "age = " + age + ", " +
                    "firstName = " + firstName + ", " +
                    "lastName = " + lastName + ", " +
                    "adresses = " + adresses + ", " +
                    "hobbys = " + hobbys + ", " +
                    "phonenumbers = " + phonenumbers + ")";
        }
    }

    /**
     * A DTO for the {@link entities.Hobby} entity
     */
    public static class HobbyInnerDTO implements Serializable {
        private final Integer id;
        @Size(max = 45)
        @NotNull
        private final String name;
        @Size(max = 45)
        @NotNull
        private final String description;

        public HobbyInnerDTO(Integer id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HobbyInnerDTO entity = (HobbyInnerDTO) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.name, entity.name) &&
                    Objects.equals(this.description, entity.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, description);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "name = " + name + ", " +
                    "description = " + description + ")";
        }
    }
}