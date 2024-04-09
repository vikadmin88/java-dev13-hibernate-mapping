package org.spacetravel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
//@ToString(onlyExplicitlyIncluded = true)
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

    @NotNull
    @OneToMany(mappedBy="fromPlanet", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
//    @OneToMany(mappedBy="fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> fromPlanet = new HashSet<>();

    @NotNull
    @OneToMany(mappedBy="toPlanet", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
//    @OneToMany(mappedBy="toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> toPlanet = new HashSet<>();
}
