package br.com.alura.dojoplaces.place;

public record PlaceResponse (
    Long id,
    String name,
    String code,
    String neighborhood,
    String city) {

    public static PlaceResponse convert(Place place) {
        return new PlaceResponse(place.getId(), place.getName(), place.getCode(), place.getNeighborhood(),
                place.getCity());
    }
}
