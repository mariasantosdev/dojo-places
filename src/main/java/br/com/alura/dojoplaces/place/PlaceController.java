package br.com.alura.dojoplaces.place;

import br.com.alura.dojoplaces.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
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
    public String create(@Valid PlaceNewForm placeForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return createLocalForm(placeForm);
        }

        Place place = placeForm.toModel();
        placeRepository.save(place);

        return "/place/newForm";
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
        return "redirect:/create/local/form";
    }
}
