package dtos;

import entities.Adress;
import entities.Person;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.Person} entity
 */
public class PersonDTO implements Serializable {
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
    private final Adress adress;
/*    private final List<String> adresses;
    private final List<String> hobbys;
    private final List<String> phonenumbers;*/

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.email = p.getEmail();
        this.gender = p.getGender();
        this.age = p.getAge();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.adress = p.getAdress();
/*        this.adresses = p.getAdresses();
        this.hobbys = p.getHobbys();
        this.phonenumbers = p.getPhonenumbers();*/
    }

    public PersonDTO(String email, String gender, Integer age, String firstName, String lastName, Adress adress) {
        this.id = 0;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO entity = (PersonDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.gender, entity.gender) &&
                Objects.equals(this.age, entity.age) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.adress, entity.adress);
/*                Objects.equals(this.adresses, entity.adresses) &&
                Objects.equals(this.hobbys, entity.hobbys) &&
                Objects.equals(this.phonenumbers, entity.phonenumbers);*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, gender, age, firstName, lastName, adress);
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
                "adress = " + adress + ", ";
/*                "adresses = " + adresses + ", " +
                "hobbys = " + hobbys + ", " +
                "phonenumbers = " + phonenumbers + ")";*/
    }

    /**
     * A DTO for the {@link entities.Adress} entity
     */
    public static class AdressDTO implements Serializable {
        private final Integer id;
        @Size(max = 45)
        @NotNull
        private final String street;
        @Size(max = 45)
        @NotNull
        private final String additionalinfo;
        private final CityinfoDTO cityinfo;

        public AdressDTO(Integer id, String street, String additionalinfo, CityinfoDTO cityinfo) {
            this.id = id;
            this.street = street;
            this.additionalinfo = additionalinfo;
            this.cityinfo = cityinfo;
        }

        public Integer getId() {
            return id;
        }

        public String getStreet() {
            return street;
        }

        public String getAdditionalinfo() {
            return additionalinfo;
        }

        public CityinfoDTO getCityinfo() {
            return cityinfo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AdressDTO entity = (AdressDTO) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.street, entity.street) &&
                    Objects.equals(this.additionalinfo, entity.additionalinfo) &&
                    Objects.equals(this.cityinfo, entity.cityinfo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, street, additionalinfo, cityinfo);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "street = " + street + ", " +
                    "additionalinfo = " + additionalinfo + ", " +
                    "cityinfo = " + cityinfo + ")";
        }

        /**
         * A DTO for the {@link entities.Cityinfo} entity
         */
        public static class CityinfoDTO implements Serializable {
            private final Integer id;
            @Size(max = 45)
            @NotNull
            private final String city;

            public CityinfoDTO(Integer id, String city) {
                this.id = id;
                this.city = city;
            }

            public Integer getId() {
                return id;
            }

            public String getCity() {
                return city;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                CityinfoDTO entity = (CityinfoDTO) o;
                return Objects.equals(this.id, entity.id) &&
                        Objects.equals(this.city, entity.city);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, city);
            }

            @Override
            public String toString() {
                return getClass().getSimpleName() + "(" +
                        "id = " + id + ", " +
                        "city = " + city + ")";
            }
        }
    }
    public static List<PersonDTO> getDTOs(List<Person> people){
        List<PersonDTO> personDTOList = new ArrayList<>();
        people.forEach(p -> personDTOList.add(new PersonDTO(p)));
        return personDTOList;
    }
}