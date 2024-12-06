package pe.edu.cibertec.spring_mvc_jyd.dto;

import pe.edu.cibertec.spring_mvc_jyd.entity.Language;

import java.util.Date;

public record FilmCreateDto(
        String title,
        String description,
        Integer releaseYear,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures,
        Integer languageId) {
}
