package br.com.alura.dojoplaces.place;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.springframework.validation.Errors;

class PlaceNewFormValidatorTest {
    private PlaceRepository placeRepository;
    private Errors errors;
    private PlaceNewFormValidator placeNewFormValidator;
    @BeforeEach
    void setUp() {
        placeRepository = mock(PlaceRepository.class);
        errors = mock(Errors.class);
        placeNewFormValidator = new PlaceNewFormValidator(placeRepository);
    }

    @Test
    void validate__should_validate_incorrect_when_code_already_exists() {
        when(placeRepository.existsByCode("code")).thenReturn(true);
        PlaceNewForm placeNewForm = new PlaceNewForm();
        placeNewForm.setCode("code");
        placeNewFormValidator.validate(placeNewForm, errors);

        verify(errors).rejectValue("code", "place.code.already.exists", "O código do lugar já existe");
    }

    @Test
    void validate__should_validate_correct_when_code_not_exists() {
        when(placeRepository.existsByCode("code")).thenReturn(false);
        PlaceNewForm placeNewForm = new PlaceNewForm();
        placeNewForm.setCode("code");
        placeNewFormValidator.validate(placeNewForm, errors);

        verify(errors, never()).rejectValue("code", "place.code.already.exists", "O código do lugar já existe");
    }
}