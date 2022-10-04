package dtos;

import entities.Hobby;
import entities.Person;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.Hobby} entity
 */
public class HobbyDTO implements Serializable {
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String name;
    @Size(max = 45)
    @NotNull
    private final String description;

    public HobbyDTO(Hobby h)
    {
        this.id = h.getId();
        this.name = h.getName();
        this.description = h.getDescription();
    }

    public HobbyDTO(String name, String description) {
        this.id = 0;
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
        HobbyDTO entity = (HobbyDTO) o;
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

    public static List<HobbyDTO> getDTOs(List<Hobby> hobby){
        List<HobbyDTO> hobbyDTOList = new ArrayList<>();
        hobby.forEach(h -> hobbyDTOList.add(new HobbyDTO(h)));
        return hobbyDTOList;
    }
}