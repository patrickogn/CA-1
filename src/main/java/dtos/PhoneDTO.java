package dtos;

import entities.Person;
import entities.PersonHasHobby;
import entities.Phone;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.Phone} entity
 */
public class PhoneDTO implements Serializable
{
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String description;
    @NotNull
    //private final PersonInnerDTO person;
    private final Person person;


    public PhoneDTO(Integer id, String description, Person person)
    {
        this.id = id;
        this.description = description;
        this.person = person;
    }

//    public PhoneDTO(Phone p)
//    {
//        this.id = p.getId();
//        this.description = p.getDescription();
//        this.person = p.getPerson();
//
//    }

    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.description = phone.getDescription();
        this.person = phone.getPerson();
    }

    public static List<PhoneDTO> getPhonedtos(List<Phone> phones)
    {
        List<PhoneDTO> phoneDTOList = new ArrayList<>();
        phones.forEach(p -> phoneDTOList.add(new PhoneDTO(p)));
        return phoneDTOList;
    }


    public Integer getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    //public PersonInnerDTO getPerson()
//    {
//        return person;
//    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneDTO entity = (PhoneDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.person, entity.person);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, description, person);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description = " + description + ", " +
                "person = " + person + ")";
    }

    /**
     * A DTO for the {@link entities.Person} entity
     */
    public static class PersonInnerDTO implements Serializable
    {
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
        @NotNull
        private final AdressInnerDTO adress;
        private final List<String> adresses;
        private final List<String> hobbys;
        private final List<String> phonenumbers;

        public PersonInnerDTO(Integer id, String email, String gender, Integer age, String firstName, String lastName, AdressInnerDTO adress, List<String> adresses, List<String> hobbys, List<String> phonenumbers)
        {
            this.id = id;
            this.email = email;
            this.gender = gender;
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
            this.adress = adress;
            this.adresses = adresses;
            this.hobbys = hobbys;
            this.phonenumbers = phonenumbers;
        }

        public Integer getId()
        {
            return id;
        }

        public String getEmail()
        {
            return email;
        }

        public String getGender()
        {
            return gender;
        }

        public Integer getAge()
        {
            return age;
        }

        public String getFirstName()
        {
            return firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public AdressInnerDTO getAdress()
        {
            return adress;
        }

        public List<String> getAdresses()
        {
            return adresses;
        }

        public List<String> getHobbys()
        {
            return hobbys;
        }

        public List<String> getPhonenumbers()
        {
            return phonenumbers;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonInnerDTO entity = (PersonInnerDTO) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.email, entity.email) &&
                    Objects.equals(this.gender, entity.gender) &&
                    Objects.equals(this.age, entity.age) &&
                    Objects.equals(this.firstName, entity.firstName) &&
                    Objects.equals(this.lastName, entity.lastName) &&
                    Objects.equals(this.adress, entity.adress) &&
                    Objects.equals(this.adresses, entity.adresses) &&
                    Objects.equals(this.hobbys, entity.hobbys) &&
                    Objects.equals(this.phonenumbers, entity.phonenumbers);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(id, email, gender, age, firstName, lastName, adress, adresses, hobbys, phonenumbers);
        }

        @Override
        public String toString()
        {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "email = " + email + ", " +
                    "gender = " + gender + ", " +
                    "age = " + age + ", " +
                    "firstName = " + firstName + ", " +
                    "lastName = " + lastName + ", " +
                    "adress = " + adress + ", " +
                    "adresses = " + adresses + ", " +
                    "hobbys = " + hobbys + ", " +
                    "phonenumbers = " + phonenumbers + ")";
        }

        /**
         * A DTO for the {@link entities.Adress} entity
         */
        public static class AdressInnerDTO implements Serializable
        {
            private final Integer id;
            @Size(max = 45)
            @NotNull
            private final String street;
            @Size(max = 45)
            @NotNull
            private final String additionalinfo;
            private final CityinfoInnerDTO cityinfo;

            public AdressInnerDTO(Integer id, String street, String additionalinfo, CityinfoInnerDTO cityinfo)
            {
                this.id = id;
                this.street = street;
                this.additionalinfo = additionalinfo;
                this.cityinfo = cityinfo;
            }

            public Integer getId()
            {
                return id;
            }

            public String getStreet()
            {
                return street;
            }

            public String getAdditionalinfo()
            {
                return additionalinfo;
            }

            public CityinfoInnerDTO getCityinfo()
            {
                return cityinfo;
            }

            @Override
            public boolean equals(Object o)
            {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                AdressInnerDTO entity = (AdressInnerDTO) o;
                return Objects.equals(this.id, entity.id) &&
                        Objects.equals(this.street, entity.street) &&
                        Objects.equals(this.additionalinfo, entity.additionalinfo) &&
                        Objects.equals(this.cityinfo, entity.cityinfo);
            }

            @Override
            public int hashCode()
            {
                return Objects.hash(id, street, additionalinfo, cityinfo);
            }

            @Override
            public String toString()
            {
                return getClass().getSimpleName() + "(" +
                        "id = " + id + ", " +
                        "street = " + street + ", " +
                        "additionalinfo = " + additionalinfo + ", " +
                        "cityinfo = " + cityinfo + ")";
            }

            /**
             * A DTO for the {@link entities.Cityinfo} entity
             */
            public static class CityinfoInnerDTO implements Serializable
            {
                private final Integer id;
                @Size(max = 45)
                @NotNull
                private final String city;

                public CityinfoInnerDTO(Integer id, String city)
                {
                    this.id = id;
                    this.city = city;
                }

                public Integer getId()
                {
                    return id;
                }

                public String getCity()
                {
                    return city;
                }

                @Override
                public boolean equals(Object o)
                {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;
                    CityinfoInnerDTO entity = (CityinfoInnerDTO) o;
                    return Objects.equals(this.id, entity.id) &&
                            Objects.equals(this.city, entity.city);
                }

                @Override
                public int hashCode()
                {
                    return Objects.hash(id, city);
                }

                @Override
                public String toString()
                {
                    return getClass().getSimpleName() + "(" +
                            "id = " + id + ", " +
                            "city = " + city + ")";
                }
            }



//            public static List<PhoneDTO> getPhonedtos(List<Phone> phones){
//                List<PhoneDTO> phoneDTOList = new ArrayList<>();
//                phones.forEach(p -> phoneDTOList.add(new PhoneDTO(p)));
//                return phoneDTOList;
//            }
        }
    }
}