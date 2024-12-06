package pe.edu.cibertec.spring_mvc_jyd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmCreateDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDetailDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDto;
import pe.edu.cibertec.spring_mvc_jyd.entity.Film;
import pe.edu.cibertec.spring_mvc_jyd.entity.Language;
import pe.edu.cibertec.spring_mvc_jyd.repository.FilmRepository;
import pe.edu.cibertec.spring_mvc_jyd.repository.LanguageRepository;
import pe.edu.cibertec.spring_mvc_jyd.service.LanguageService;
import pe.edu.cibertec.spring_mvc_jyd.service.MaintenanceService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<FilmDto> findAllFilms() {

        List<FilmDto> films = new ArrayList<FilmDto>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalDuration(),
                    film.getRentalRate());
            films.add(filmDto);
        });
        return films;

    }

    @Override
    public FilmDetailDto findDetailById(Integer id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(
                film->new FilmDetailDto(film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate()
                        )
            ).orElse(null);

    }

    @Override
    public void createFilm(FilmCreateDto filmComplete) {
        Language language = languageRepository.findById(filmComplete.languageId())
                .orElseThrow(() -> new IllegalArgumentException("El lenguaje con ID " + filmComplete.languageId() + " no existe"));

        Film film = new Film();
        film.setTitle(filmComplete.title());
        film.setDescription(filmComplete.description());
        film.setReleaseYear(filmComplete.releaseYear());
        film.setRentalDuration(filmComplete.rentalDuration());
        film.setRentalRate(filmComplete.rentalRate());
        film.setLength(filmComplete.length());
        film.setReplacementCost(filmComplete.replacementCost());
        film.setRating(filmComplete.rating());
        film.setSpecialFeatures(filmComplete.specialFeatures());
        film.setLanguage(language);
        film.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        System.out.println(film);
        filmRepository.save(film);
    }

    @Override
    public Boolean updateFilm(FilmDetailDto filmDetailDto) {

        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        return optional.map(
                film -> {
                    film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(false);

    }

    @Override
    public Boolean deleteFilm(Integer id) {
        return filmRepository.findById(id).map(film -> {
            filmRepository.deleteById(film.getFilmId());
            return true;
        }).orElse(false);
    }

}
