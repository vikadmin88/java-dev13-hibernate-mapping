package org.spacetravel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "planet")
public class Planet {

    @Id
    @NotNull
    @Size(min = 1, max = 10, message = "The length of the field id must be from 1 to 10 characters!")
    @Pattern(regexp = "^[0-9A-Z]+$", message = "The field id must contain only numbers and chars in upper case!")
    private String id;

    @Column
    @NotNull
    @Size(min = 1, max = 500, message = "The length of the field name must be from 3 to 500 characters!")
    private String name;
}
