package pe.edu.cibertec.spring_mvc_jyd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmCreateDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDetailDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.LanguageDto;
import pe.edu.cibertec.spring_mvc_jyd.repository.LanguageRepository;
import pe.edu.cibertec.spring_mvc_jyd.service.LanguageService;
import pe.edu.cibertec.spring_mvc_jyd.service.MaintenanceService;

import javax.annotation.processing.Generated;
import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;
    @Autowired
    private LanguageService languageService;


    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<LanguageDto> languages = languageService.findAllLanguages();
        model.addAttribute("languages", languages);

        return "maintenance-create";
    }

    @PostMapping("/confirm-create")
    public String createFilm(@ModelAttribute FilmCreateDto filmData, Model model) {
        try {
            maintenanceService.createFilm(filmData);
            return "redirect:/maintenance/start";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Ocurrió un error inesperado al crear la película.");
            return "maintenance-create";
        }
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-edit";
    }

    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute FilmDetailDto film, Model model) {
        maintenanceService.updateFilm(film);
        return "redirect:/maintenance/start";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Boolean resultado = maintenanceService.deleteFilm(id);
        String message = resultado ? "Eliminacion exitosa" : "No se encontró valor o error en algun punto" ;

        model.addAttribute("message", message);
        return "redirect:/maintenance/start";
    }

}