package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Size(max = 45)
    @NotNull
    @Column(name = "gender", nullable = false, length = 45)
    private String gender;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @Size(max = 45)
    @NotNull
    @Column(name = "firstName", nullable = false, length = 45)
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adress_id", nullable = false)
    private Adress adress;

    @ElementCollection
    private List<String> adresses;

    @ElementCollection
    private List<String> hobbys;

    @ElementCollection
    private List<String> phonenumbers;


    public Person() {
    }

    public Person(String email, String gender, Integer age, String firstName, String lastName, Adress adress, List<String> adresses, List<String> hobbys, List<String> phonenumbers) {
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

    public Person(String email, String gender, Integer age, String firstName, String lastName, Adress adress) {
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

    public void setId(Integer id) {
        this.id = id;
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
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress=" + adress +
                ", adresses=" + adresses +
                ", hobbys=" + hobbys +
                ", phonenumbers=" + phonenumbers +
                '}';
    }
}