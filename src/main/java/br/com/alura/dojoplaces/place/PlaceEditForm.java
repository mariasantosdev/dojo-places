package br.com.alura.dojoplaces.place;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PlaceEditForm {
    @NotNull
    private Long id;
    @Size(max = 100)
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @NotBlank(message = "Código é obrigatório")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Código deve conter apenas letras e números")
    private String code;
    @Size(max = 100)
    @NotBlank(message = "Bairro é obrigatório")
    private String neighborhood;
    @Size(max = 100)
    @NotBlank(message = "Cidade é obrigatória")
    private String city;

    @Deprecated
    public PlaceEditForm() {}

    public PlaceEditForm(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.code = place.getCode();
        this.neighborhood = place.getNeighborhood();
        this.city = place.getCity();
    }

    public Long getId() {
        return id;
    }

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

    public void setId(Long id) {
        this.id = id;
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
}
