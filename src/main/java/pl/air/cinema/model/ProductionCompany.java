package pl.air.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "production_companies")
@AttributeOverride(column = @Column(name = "pro_id"), name = "id")
@NoArgsConstructor
@Getter
@Setter

public class ProductionCompany extends BaseEntity{

    @Column
    private String name;


    @Column
    private LocalDate founded;
}
