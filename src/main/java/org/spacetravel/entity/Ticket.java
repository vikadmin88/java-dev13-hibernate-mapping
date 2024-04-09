package org.spacetravel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "createdAt field null impossible")
    @Column(name = "created_at")
    private Timestamp createdAt;

    @NotNull(message = "Client field null impossible")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @NotNull(message = "fromPlanet field null impossible")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="from_planet_id", nullable=false)
    private Planet fromPlanet;

    @NotNull(message = "toPlanet field null impossible")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="to_planet_id", nullable=false)
    private Planet toPlanet;
}
