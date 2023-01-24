package peaksoft.laptops;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.OprSystem;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Baiysh155f. ttask
 * 24.01.2023
 * admin
 * вт
 **/
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    @Enumerated(EnumType.STRING)
    private OprSystem operationSystem;
    private int memory;
    private BigDecimal price;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Laptop(String brand, OprSystem operationSystem, int memory, BigDecimal price, LocalDate dateOfBirth) {
        this.brand = brand;
        this.operationSystem = operationSystem;
        this.memory = memory;
        this.price = price;
        this.dateOfBirth = dateOfBirth;
    }

    public Laptop() {
    }
}
