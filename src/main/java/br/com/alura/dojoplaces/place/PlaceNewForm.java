package br.com.alura.dojoplaces.place;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PlaceNewForm {
    @Size(max = 100)
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]+")
    private String code;
    @Size(max = 100)
    @NotBlank
    private String neighborhood;
    @Size(max = 100)
    @NotBlank
    private String city;

    @Deprecated
    public PlaceNewForm() {}

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Place toModel() {
        return new Place(name, code, neighborhood, city);
    }
}
