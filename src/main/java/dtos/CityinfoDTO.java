package dtos;

import entities.Adress;
import entities.Cityinfo;
import entities.Hobby;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.Cityinfo} entity
 */
public class CityinfoDTO implements Serializable
{
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String city;

    public CityinfoDTO(Integer id, String city)
    {
        this.id = id;
        this.city = city;
    }

    public CityinfoDTO(Cityinfo c)
    {
        this.id = c.getId();
        this.city = c.getCity();
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
        CityinfoDTO entity = (CityinfoDTO) o;
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

    public static List<CityinfoDTO> getDTOs(List<Cityinfo> cityinfos){
        List<CityinfoDTO> cityinfoDTOList = new ArrayList<>();
        cityinfos.forEach(c -> cityinfoDTOList.add(new CityinfoDTO(c)));
        return cityinfoDTOList;
    }

}