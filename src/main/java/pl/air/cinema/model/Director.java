package pl.air.cinema.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
@AttributeOverride(column = @Column(name = "dir_id"), name = "id")
@NoArgsConstructor
@Getter
@Setter
public class Director extends Human {

}
