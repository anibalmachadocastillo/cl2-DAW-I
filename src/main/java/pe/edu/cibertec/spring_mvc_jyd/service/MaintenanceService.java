package pe.edu.cibertec.spring_mvc_jyd.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmCreateDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDetailDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDto;

import java.util.List;

@Service
public interface MaintenanceService {
    List<FilmDto> findAllFilms();

    FilmDetailDto findDetailById(Integer id);

    void createFilm(FilmCreateDto filmComplete);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean deleteFilm(Integer id);
}
