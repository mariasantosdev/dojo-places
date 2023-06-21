package br.com.alura.dojoplaces.place;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PlaceNewFormValidator implements Validator {

    private final PlaceRepository placeRepository;

    public PlaceNewFormValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceNewForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        PlaceNewForm form = (PlaceNewForm) target;
        if (placeRepository.existsByCode(form.getCode())) {
            errors.rejectValue("code", "place.code.already.exists", "O código do lugar já existe");
        }
    }
}
