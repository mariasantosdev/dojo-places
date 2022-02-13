package br.com.alura.dojoplaces.place;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @PastOrPresent
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @Deprecated
    public Place() {}

    public Place(String name, String code, String neighborhood, String city) {
        this.name = name;
        this.code = code;
        this.neighborhood = neighborhood;
        this.city = city;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void update(PlaceEditForm placeEditForm) {
        this.name = placeEditForm.getName();
        this.code = placeEditForm.getCode();
        this.neighborhood = placeEditForm.getNeighborhood();
        this.city = placeEditForm.getCity();
    }
}
