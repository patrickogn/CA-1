package dtos;

import entities.Adress;
import entities.Cityinfo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.Adress} entity
 */
public class AdressDTO implements Serializable
{
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String street;
    @Size(max = 45)
    @NotNull
    private final String additionalinfo;
    //private final CityinfoInnerDto cityinfo;

    public AdressDTO(Integer id, String street, String additionalinfo, CityinfoInnerDto cityinfo)
    {
        this.id = id;
        this.street = street;
        this.additionalinfo = additionalinfo;
        //this.cityinfo = cityinfo;
    }

    public AdressDTO(Adress a)
    {
        this.id = a.getId();
        this.street = a.getStreet();
        this.additionalinfo = a.getAdditionalinfo();
        //this.cityinfo = a. mÃ¥ske er den vigtig;

    }

//    public static List<AdressDTO> getDTOs(List<Adress> adresses)
//    {
//        List<AdressDTO> adressDTOList = new ArrayList<>();
//        adresses.forEach(a -> adressDTOList.add(new AdressDTO(a)));
//        return adressDTOList;
//    }

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

    //public CityinfoInnerDto getCityinfo()
//    {
//        return cityinfo;
//    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdressDTO entity = (AdressDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.street, entity.street) &&
                Objects.equals(this.additionalinfo, entity.additionalinfo);
//                &&
//               Objects.equals(this.cityinfo, entity.cityinfo);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, street, additionalinfo);
        //cityinfo);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "street = " + street + ", " +
                "additionalinfo = " + additionalinfo + ", " +")";
        //"cityinfo = " + cityinfo + ")";
    }

    /**
     * A DTO for the {@link entities.Cityinfo} entity
     */
    public static class CityinfoInnerDto implements Serializable
    {
        private final Integer id;
        @Size(max = 45)
        @NotNull
        private final String city;

        public CityinfoInnerDto(Integer id, String city)
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
            CityinfoInnerDto entity = (CityinfoInnerDto) o;
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


        public static List<AdressDTO> getDTOs(List<Adress> adresses){
            List<AdressDTO> adressDTOList = new ArrayList<>();
            adresses.forEach(a -> adressDTOList.add(new AdressDTO(a)));
            return adressDTOList;
        }


    }
}