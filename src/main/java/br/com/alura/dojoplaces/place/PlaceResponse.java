package br.com.alura.dojoplaces.place;

import static br.com.alura.dojoplaces.utils.OffsetDateTimeUtil.formatOffsetDateTime;

public record PlaceResponse (
    Long id,
    String name,
    String code,
    String createdAt,
    String updatedAt) {

    public static PlaceResponse convert(Place place) {
        return new PlaceResponse(place.getId(), place.getName(), place.getCode(), formatOffsetDateTime(place.getCreatedAt()),
                formatOffsetDateTime(place.getUpdatedAt().orElse(null)));
    }
}
