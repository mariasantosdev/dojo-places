package br.com.alura.dojoplaces.place;

public class PlaceEditView {
    private Long id;
    private final String name;
    private final String code;
    private final String neighborhood;
    private final String city;

    public PlaceEditView(Place place) {
        this.id = place.getId();
        this.code = place.getCode();
        this.city = place.getCity();
        this.neighborhood = place.getNeighborhood();
        this.name = place.getName();
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
}
