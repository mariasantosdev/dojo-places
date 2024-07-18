package br.com.alura.dojoplaces.place;

import br.com.alura.dojoplaces.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PlaceController {

    private final PlaceRepository placeRepository;
    private final PlaceNewFormValidator placeNewFormValidator;
    private final PlaceEditFormValidator editPlaceValidator;

    public PlaceController(PlaceRepository placeRepository, PlaceNewFormValidator placeNewFormValidator,
                           PlaceEditFormValidator editPlaceValidator) {
        this.placeRepository = placeRepository;
        this.placeNewFormValidator = placeNewFormValidator;
        this.editPlaceValidator = editPlaceValidator;
    }

    @InitBinder("placeNewForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(placeNewFormValidator);
    }

    @InitBinder("placeEditForm")
    public void init(WebDataBinder binder) {
        binder.addValidators(editPlaceValidator);
    }

    @GetMapping("/places")
    public String list(Model model) {
        List<PlaceResponse> places = placeRepository.findAll().stream().map(PlaceResponse::convert).toList();

        model.addAttribute("places", places);
        return "place/list";
    }

    @GetMapping("/create/local/form")
    public String createLocalForm(PlaceNewForm placeNewForm) {
        return "/place/newForm";
    }

    @PostMapping("/create/local")
    public String create(@Valid PlaceNewForm placeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return createLocalForm(placeForm);
        }

        Place place = placeForm.toModel();
        placeRepository.save(place);

        return "redirect:/places";
    }

    @GetMapping("update/local/form/{code}")
    public String updateLocalForm(@PathVariable String code, Model model) {
        Place place = placeRepository.findByCode(code).orElseThrow(NotFoundException::new);

        model.addAttribute("placeEditForm", new PlaceEditForm(place));
        return "place/updateForm";
    }

    @PostMapping("update/local/{code}")
    @Transactional
    public String update(@PathVariable String code, @Valid PlaceEditForm placeEditForm,
                         BindingResult result, Model model) {
        if(result.hasErrors()) {
            return updateLocalForm(code,model);
        }
        Place place = placeRepository.findByCode(code).orElseThrow(NotFoundException::new);

        place.update(placeEditForm);
        model.addAttribute("code", code);
        return "redirect:/places";
    }

    @PostMapping("/delete/local/{code}")
    @Transactional
    public String delete(@PathVariable String code, Model model) {
        Place place = placeRepository.findByCode(code).orElseThrow(NotFoundException::new);
        placeRepository.delete(place);
        return "redirect:/places";
    }
}
