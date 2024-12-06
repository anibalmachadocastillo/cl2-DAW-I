package pe.edu.cibertec.spring_mvc_jyd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film_Actor_Id {
    @Column(name = "actor_id")
    private Integer actor;

    @Column(name = "film_id")
    private Integer film;
}
