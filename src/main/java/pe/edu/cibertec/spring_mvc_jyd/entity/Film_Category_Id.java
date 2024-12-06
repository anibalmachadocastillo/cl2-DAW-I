package pe.edu.cibertec.spring_mvc_jyd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film_Category_Id {
    @Column(name = "film_id")
    private Integer film;

    @Column(name = "category_id")
    private Integer category;
}
