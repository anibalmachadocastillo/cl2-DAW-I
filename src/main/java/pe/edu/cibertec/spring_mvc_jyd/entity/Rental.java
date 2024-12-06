package pe.edu.cibertec.spring_mvc_jyd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalId;
    private Date rentalDate;
    private Date return_date;
    private Date last_update;

    @ManyToOne
    @JoinColumn(name ="inventory_id", nullable = false)
    private Inventory inventory;
}
