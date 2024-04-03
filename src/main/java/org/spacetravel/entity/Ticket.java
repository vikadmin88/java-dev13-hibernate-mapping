package org.spacetravel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "client_id")
    private long clientId;

    @NotNull
    @Size(min = 1, max = 10, message = "The length of the field from_planet_id must be from 1 to 10 characters!")
    @Column(name = "from_planet_id")
    private String fromPlanetId;

    @NotNull
    @Size(min = 1, max = 10, message = "The length of the field to_planet_id must be from 1 to 10 characters!")
    @Column(name = "to_planet_id")
    private String toPlanetId;

}
