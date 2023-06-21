package br.com.alura.dojoplaces.place;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PlaceEditFormValidator implements Validator {


    private final PlaceRepository placeRepository;

    public PlaceEditFormValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PlaceEditForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        PlaceEditForm form = (PlaceEditForm) target;

        if (placeRepository.existsByCodeAndIdNot(form.getCode(), form.getId())) {
            errors.rejectValue("code", "place.code.already.exists", "O código do lugar já existe");
        }

    }
}
